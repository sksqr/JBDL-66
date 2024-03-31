package com.gfg.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfg.TxnCompletedPayload;

import com.gfg.TxnStatusEnum;

import com.gfg.entity.Transaction;

import com.gfg.repo.TransactionRepo;
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
    private TransactionRepo transactionRepo;

    @KafkaListener(topics = "${txn.completed.topic}", groupId = "txnApp")
    public void consumeTxnCompleted(ConsumerRecord payload) throws JsonProcessingException, ExecutionException, InterruptedException {
        TxnCompletedPayload txnCompletedPayload = OBJECT_MAPPER.readValue(payload.value().toString(), TxnCompletedPayload.class);
        MDC.put("requestId", txnCompletedPayload.getRequestId());
        LOGGER.info("Read from kafka TxnCompleted : {}", txnCompletedPayload);

        Transaction transaction = transactionRepo.findById(txnCompletedPayload.getId()).get();
        if(txnCompletedPayload.getSuccess()){
            transaction.setStatus(TxnStatusEnum.SUCCESS);
        }
        else{
            transaction.setStatus(TxnStatusEnum.FAILED);
            transaction.setReason(txnCompletedPayload.getReason());
        }
        transactionRepo.save(transaction);
    }

}
