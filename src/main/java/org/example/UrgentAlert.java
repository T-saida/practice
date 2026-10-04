package org.example;

public class UrgentAlert extends Notification {

    // Обязательно должен быть public!
    public UrgentAlert(String id, String messageContent, Channel channel) {
        super(id, messageContent, channel);
    }

    @Override
    public String execute() {
        return channel.deliver("URGENT: " + messageContent);
    }
}