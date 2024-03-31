package com.gfg.service;

import com.gfg.UserCreatedPayload;
import com.gfg.dto.UserDto;
import com.gfg.entity.User;
import com.gfg.repo.UserRepo;

import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Service
public class UserService {


    private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);


    @Value("${user.created.topic}")
    private String userCreatedTopic;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private KafkaTemplate<String,Object> kafkaTemplate;


    @Transactional
    public Long createUser(UserDto userDto) throws ExecutionException, InterruptedException {
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setKycNumber(userDto.getKycNumber());
        user = userRepo.save(user);
        UserCreatedPayload userCreatedPayload = new UserCreatedPayload();
        userCreatedPayload.setUserEmail(user.getEmail());
        userCreatedPayload.setUserId(user.getId());
        userCreatedPayload.setUserName(user.getName());
        userCreatedPayload.setRequestId(MDC.get("requestId"));
        Future<SendResult<String,Object>> future  = kafkaTemplate.send(userCreatedTopic,userCreatedPayload.getUserEmail(),userCreatedPayload);
        LOGGER.info("Pushed userCreatedPayload to kafka: {}",future.get());
        return user.getId();
    }

}
