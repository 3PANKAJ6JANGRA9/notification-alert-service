package com.notification.alert.msg.service;

import com.notification.alert.msg.extend.Notification;
import org.springframework.stereotype.Component;

@Component
public class EmailNotification implements Notification {
    @Override
    public void send(String recipient, String message)
    {
        System.out.println("Sending Email to :"+recipient +" message is: "+message);
    }

    @Override
    public String getChannelName()
    {
       return "Email";
    }

}
