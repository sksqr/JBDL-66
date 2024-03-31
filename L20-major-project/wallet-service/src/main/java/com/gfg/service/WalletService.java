package com.gfg.service;

import com.gfg.TxnCompletedPayload;
import com.gfg.TxnInitPayload;
import com.gfg.WalletUpdatedPayload;
import com.gfg.entity.Wallet;
import com.gfg.repo.WalletRepo;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class WalletService {
    private static Logger LOGGER = LoggerFactory.getLogger(WalletService.class);
    @Autowired
    private WalletRepo walletRepo;

    @Value("${txn.completed.topic}")
    private String txnCompletedTopic;

    @Value("${wallet.updated.topic}")
    private String walletUpdatedTopic;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Transactional
    public void walletTxn(TxnInitPayload txnInitPayload) throws ExecutionException, InterruptedException {
        LOGGER.info("Process wallet transaction");
        Wallet fromWallet = walletRepo.findByUserId(txnInitPayload.getFromUserId());
        TxnCompletedPayload txnCompletedPayload = TxnCompletedPayload.builder()
                .id(txnInitPayload.getId())
                .requestId(txnInitPayload.getRequestId())
                .build();
        if(fromWallet.getBalance() < txnInitPayload.getAmount()){
            txnCompletedPayload.setSuccess(false);
            txnCompletedPayload.setReason("Low Balance");
        }
        else {
            Wallet toWallet = walletRepo.findByUserId(txnInitPayload.getToUserId());
            fromWallet.setBalance(fromWallet.getBalance() - txnInitPayload.getAmount());
            toWallet.setBalance(toWallet.getBalance() + txnInitPayload.getAmount());
            txnCompletedPayload.setSuccess(true);

            WalletUpdatedPayload walletUpdatedPayload1 = WalletUpdatedPayload.builder()
                    .balance(fromWallet.getBalance())
                    .userEmail(fromWallet.getUserEmail())
                    .requestId(txnInitPayload.getRequestId())
                    .build();

            WalletUpdatedPayload walletUpdatedPayload2 = WalletUpdatedPayload.builder()
                    .balance(toWallet.getBalance())
                    .userEmail(toWallet.getUserEmail())
                    .requestId(txnInitPayload.getRequestId())
                    .build();

            Future<SendResult<String,Object>> future1  = kafkaTemplate.send(walletUpdatedTopic,txnInitPayload.getFromUserId().toString(),walletUpdatedPayload1);
            LOGGER.info("Pushed WalletUpdated topic to kafka: {}",future1.get());

            Future<SendResult<String,Object>> future2  = kafkaTemplate.send(walletUpdatedTopic,txnInitPayload.getToUserId().toString(),walletUpdatedPayload2);
            LOGGER.info("Pushed WalletUpdated topic to kafka: {}",future2.get());

        }
        Future<SendResult<String,Object>> future  = kafkaTemplate.send(txnCompletedTopic,txnInitPayload.getFromUserId().toString(),txnCompletedPayload);
        LOGGER.info("Pushed TxnCompleted to kafka: {}",future.get());
    }
}
