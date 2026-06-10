package com.notification.alert.msg.service;

import com.notification.alert.msg.extend.Notification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NotificationService {
    private final Map<String, Notification> channels= new HashMap<>();

    public NotificationService(List<Notification> channelsList)
    {
        for(Notification channel : channelsList)
        {
            this.channels.put(channel.getChannelName().toLowerCase(),channel);
        }
    }

    public void sendNotification(String recipient, String message,String channelType)
    {
        Notification channel=channels.get(channelType.toLowerCase());
        if(channel!=null)
        {
            channel.send(recipient,message);
        }
        else
        {
            throw new IllegalArgumentException("Unknown channel Name found...."+channelType);
        }
    }

}
