package com.notification.alert.msg.extend;

public interface Notification {
    void send(String recipient , String message);
    String getChannelName();
}
