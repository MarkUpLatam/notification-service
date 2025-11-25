package com.markup.notificationservice.domain.port;

import com.markup.notificationservice.domain.model.Notification;

public interface SendNotificationUseCase {
    void sendWelcomeEmail(Notification notification);
}
