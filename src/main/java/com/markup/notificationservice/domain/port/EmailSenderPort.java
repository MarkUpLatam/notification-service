package com.markup.notificationservice.domain.port;

public interface EmailSenderPort {
    void send(String to, String subject, String html);
}
