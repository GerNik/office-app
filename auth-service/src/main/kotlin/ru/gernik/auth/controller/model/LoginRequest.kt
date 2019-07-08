package ru.gernik.auth.controller.model

import javax.validation.constraints.NotBlank

data class LoginRequest(
        @NotBlank
        val login: String,
        @NotBlank
        val password: String
)