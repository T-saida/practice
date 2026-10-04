package org.example;

public class Reminder extends Notification {

    // Обязательно должен быть public!
    public Reminder(String id, String messageContent, Channel channel) {
        super(id, messageContent, channel);
    }

    @Override
    public String execute() {
        return channel.deliver("Reminder: " + messageContent);
    }
}