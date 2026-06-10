package com.notification.alert.msg.service;

import com.notification.alert.msg.extend.Notification;
import org.springframework.stereotype.Component;

@Component
public class WhatsAppNotification implements Notification {
    @Override
    public void send(String recipient, String message)
    {
        System.out.println("Sending WhatsApp Notification to : "+recipient+" message is: "+message);
    }
    @Override
    public String getChannelName()
    {
        return "WhatsApp";
    }
}
