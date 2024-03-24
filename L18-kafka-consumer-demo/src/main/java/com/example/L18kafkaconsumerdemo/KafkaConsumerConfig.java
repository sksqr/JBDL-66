package com.example.L18kafkaconsumerdemo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerConfig.class);

    @Autowired
    private JavaMailSender javaMailSender;

    private ObjectMapper objectMapper = new ObjectMapper();

    @KafkaListener(topics = "topic01", groupId = "sms")
    public void consumeFromTopic01(Object payload) throws JsonProcessingException {
        LOGGER.info("Getting payload from kafka: {}", payload);
        String payloadValue = (String) ((ConsumerRecord)payload).value();
        EmailRequest emailRequest = objectMapper.readValue(payloadValue,EmailRequest.class);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("jbdl.ewallet@gmail.com");
        simpleMailMessage.setSubject(emailRequest.getSubject());
        simpleMailMessage.setText(emailRequest.getBody());
        simpleMailMessage.setCc(emailRequest.getCc());
        simpleMailMessage.setTo(emailRequest.getToEmail());
        javaMailSender.send(simpleMailMessage);
    }
}
