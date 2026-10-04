package org.example;

public class EmailChannel implements Channel {
    @Override
    public String deliver(String message) {
        return "Email Envelope: [" + message + "]";
    }
}
