package org.example;

public class SmsChannel implements Channel {
    @Override
    public String deliver(String message) {
        return "SMS: " + message;
    }
}