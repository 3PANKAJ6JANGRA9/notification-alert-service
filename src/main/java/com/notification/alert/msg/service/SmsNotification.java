package com.notification.alert.msg.service;

import com.notification.alert.msg.extend.Notification;
import org.springframework.stereotype.Component;

@Component
public class SmsNotification implements Notification{
    @Override
    public void send(String recipient , String message)
    {
        System.out.println("sending SMS to "+recipient+" message is: "+message);
    }
    @Override
    public  String getChannelName()
    {
        return "SMS";
    }

}
