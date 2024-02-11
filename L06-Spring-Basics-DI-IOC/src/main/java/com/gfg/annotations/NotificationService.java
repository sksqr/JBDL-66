package com.gfg.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class NotificationService {

//    @Autowired
    private SMSGatewayService smsGatewayService;

    //    @Autowired
    public NotificationService(SMSGatewayService smsGatewayService) {
        this.smsGatewayService = smsGatewayService;
    }

    public NotificationService() {
        System.out.println("Default");
    }

    @Autowired
    public void setSmsGatewayService(SMSGatewayService smsGatewayService) {
        this.smsGatewayService = smsGatewayService;
    }

    public void sendNotification(String msg){
        smsGatewayService.sendSMS(msg);
    }
}
