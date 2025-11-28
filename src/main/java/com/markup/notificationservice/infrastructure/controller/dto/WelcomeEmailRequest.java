package com.markup.notificationservice.infrastructure.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record WelcomeEmailRequest(

        @Email(message = "Correo invalido")
        @NotBlank(message = "El correo es obligatorio")
        @Size(max = 100)
        String email,

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 50)
        String firstName,

        @NotBlank(message = "El apellido es obligatorio")
        @Size(max = 50)
        String lastName,

        @NotBlank(message = "La contraseña es obligatoria")
        @Size(max = 50)
        String password

) {}