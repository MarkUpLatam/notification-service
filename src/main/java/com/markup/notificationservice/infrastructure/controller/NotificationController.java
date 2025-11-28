package com.markup.notificationservice.infrastructure.controller;

import com.markup.notificationservice.domain.model.Notification;
import com.markup.notificationservice.domain.port.SendNotificationUseCase;
import com.markup.notificationservice.infrastructure.controller.dto.WelcomeEmailRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private static final Logger log = LoggerFactory.getLogger(NotificationController.class);

    private final SendNotificationUseCase sendNotificationUseCase;

    @PostMapping("/welcome")
    public ResponseEntity<Void> sendWelcomeEmail(@Valid @RequestBody WelcomeEmailRequest request){

        Notification notification = new Notification(
                request.email(),
                "Bienvenido a la plataforma",
                "<h1>Hola " + request.firstName() + " " + request.lastName() + "!</h1>",
                request.password()
        );

        sendNotificationUseCase.sendWelcomeEmail(notification);

        return ResponseEntity.ok().build();
    }
}
