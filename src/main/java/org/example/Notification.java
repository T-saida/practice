package org.example;

public abstract class Notification {
    protected Channel channel;
    protected String id;
    protected String messageContent;

    // Обязательно должен быть public!
    public Notification(String id, String messageContent, Channel channel) {
        this.id = id;
        this.messageContent = messageContent;
        this.channel = channel;
    }

    public void setImplementation(Channel channel) {
        this.channel = channel;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getId() {
        return id;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public abstract String execute();
}