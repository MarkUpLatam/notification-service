package com.markup.notificationservice.application.usecase;

import com.markup.notificationservice.domain.model.Notification;
import com.markup.notificationservice.domain.port.EmailSenderPort;
import com.markup.notificationservice.domain.port.SendNotificationUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendWelcomeEmailUseCaseImpl implements SendNotificationUseCase {

    private final EmailSenderPort emailSender;
    private final TemplateEngine emailTemplateEngine;

    @Override
    public void sendWelcomeEmail(Notification notification) {

        Context ctx = new Context();
        ctx.setVariable("name", notification.getMessageHtml());
        ctx.setVariable("password", notification.getPassword());

        String htmlContent = emailTemplateEngine.process("welcome-email", ctx);

        log.info("Enviando email a {}", notification.getTo());

        emailSender.send(
                notification.getTo(),
                notification.getSubject(),
                htmlContent
        );

        log.info("Email de bienvenida enviado correctamente");
    }
}
