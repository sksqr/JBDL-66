package com.example.L18kafkademo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/kafka")
public class KafkaDemoController {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaDemoController.class);

    @Autowired
    private KafkaTemplate<String,Object> kafkaObjectTemplate;

    @Autowired
    private JavaMailSender javaMailSender;



    @PostMapping("/sendEmail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) throws ExecutionException, InterruptedException {
        //Future<SendResult<String,String>> future =  kafkaTemplate.send("jbdl-p2",emailRequest.getToEmail(),emailRequest.toString());
        //Future<SendResult<String,Object>> future =  kafkaObjectTemplate.send("topic01",emailRequest.getToEmail(),emailRequest);
        //LOGGER.info("Pushed payload to kafka: {}",future.get());

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("jbdl.ewallet@gmail.com");
        simpleMailMessage.setSubject(emailRequest.getSubject());
        simpleMailMessage.setText(emailRequest.getBody());
        simpleMailMessage.setCc(emailRequest.getCc());
        simpleMailMessage.setTo(emailRequest.getToEmail());
        javaMailSender.send(simpleMailMessage);

        return ResponseEntity.ok("Data Pushed");
    }


    @PostMapping("/sendEmailAsync")
    public ResponseEntity<String> sendEmailAsync(@RequestBody EmailRequest emailRequest) throws ExecutionException, InterruptedException {
        Future<SendResult<String,Object>> future =  kafkaObjectTemplate.send("topic01",emailRequest.getToEmail(),emailRequest);
        LOGGER.info("Pushed payload to kafka: {}",future.get());

        return ResponseEntity.ok("Data Pushed");
    }


}
