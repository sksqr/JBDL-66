package com.gfg.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfg.TxnInitPayload;
import com.gfg.UserCreatedPayload;
import com.gfg.entity.Wallet;
import com.gfg.repo.WalletRepo;
import com.gfg.service.WalletService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.ExecutionException;

@Configuration
public class KafkaConsumerConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private WalletRepo walletRepo;

    @Autowired
    private WalletService walletService;

    @KafkaListener(topics = "${user.created.topic}", groupId = "walletApp")
    public void consumeUserCreatedTopic(ConsumerRecord payload) throws JsonProcessingException {
        UserCreatedPayload userCreatedPayload = OBJECT_MAPPER.readValue(payload.value().toString(),UserCreatedPayload.class);
        MDC.put("requestId",userCreatedPayload.getRequestId());
        LOGGER.info("Read from kafka : {}",userCreatedPayload);
        Wallet wallet = new Wallet();
        wallet.setBalance(100.00);
        wallet.setUserId(userCreatedPayload.getUserId());
        wallet.setUserEmail(userCreatedPayload.getUserEmail());
        walletRepo.save(wallet);
        MDC.clear();;
    }

    @KafkaListener(topics = "${txn.init.topic}", groupId = "walletApp")
    public void consumeTxnInit(ConsumerRecord payload) throws JsonProcessingException, ExecutionException, InterruptedException {
        TxnInitPayload txnInitPayload = OBJECT_MAPPER.readValue(payload.value().toString(), TxnInitPayload.class);
        MDC.put("requestId", txnInitPayload.getRequestId());
        LOGGER.info("Read from kafka TxnInit : {}", txnInitPayload);
        walletService.walletTxn(txnInitPayload);
    }

}
