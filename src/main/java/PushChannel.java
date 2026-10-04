package org.example;

public class PushChannel implements Channel {
    @Override
    public String deliver(String message) {
        return "Push Notification: {" + message + "}";
    }
}