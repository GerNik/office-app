package ru.gernik.auth.controller.model

data class AuthResponse(
        val accessToken: String,
        val refreshToken: String
)