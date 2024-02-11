package com.gfg.annotations;

import org.springframework.stereotype.Component;


@Component
public class SMSGatewayService {

    public void sendSMS(String data){
        System.out.println("Sending SMS:"+data);
    }
}
