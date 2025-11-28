package com.markup.notificationservice.domain.model;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    private String to;
    private String subject;
    private String messageHtml;
    private String password;
}


