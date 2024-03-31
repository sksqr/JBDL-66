package com.gfg.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gfg.UserCreatedPayload;

import com.gfg.WalletUpdatedPayload;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class KafkaConsumerConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    private static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private JavaMailSender javaMailSender;


    @KafkaListener(topics = "${user.created.topic}", groupId = "email")
    public void consumeUserCreatedTopic(ConsumerRecord payload) throws JsonProcessingException {
        UserCreatedPayload userCreatedPayload = OBJECT_MAPPER.readValue(payload.value().toString(),UserCreatedPayload.class);
        MDC.put("requestId",userCreatedPayload.getRequestId());
        LOGGER.info("Read from kafka : {}",userCreatedPayload);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("jbdl.ewallet@gmail.com");
        simpleMailMessage.setSubject("Welcome "+userCreatedPayload.getUserName());
        simpleMailMessage.setText("Hi "+userCreatedPayload.getUserName()+", Welcome in JBDL wallet world");
        simpleMailMessage.setCc("admin.jbdl@yopmail.com");
        simpleMailMessage.setTo(userCreatedPayload.getUserEmail());
        javaMailSender.send(simpleMailMessage);
        MDC.clear();;
    }


    @KafkaListener(topics = "${wallet.updated.topic}", groupId = "email")
    public void consumeWalletUpdatedTopic(ConsumerRecord payload) throws JsonProcessingException {
        WalletUpdatedPayload walletUpdatedPayload = OBJECT_MAPPER.readValue(payload.value().toString(),WalletUpdatedPayload.class);
        MDC.put("requestId",walletUpdatedPayload.getRequestId());
        LOGGER.info("Read from kafka : {}",walletUpdatedPayload);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("jbdl.ewallet@gmail.com");
        simpleMailMessage.setSubject("JBDL Wallet Updated");
        simpleMailMessage.setText("Hi, You updated balance is "+walletUpdatedPayload.getBalance());
        simpleMailMessage.setCc("admin.jbdl@yopmail.com");
        simpleMailMessage.setTo(walletUpdatedPayload.getUserEmail());
        javaMailSender.send(simpleMailMessage);
        MDC.clear();;
    }


}
