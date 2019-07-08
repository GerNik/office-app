package ru.gernik.auth.domain

data class UserDTO(
        val id: String?,
        val login: String,
        val password: String,
        val name: String,
        val surname: String,
        val middleName: String?,
        val email: String,
        val phoneNumber: String?,
        val roles: List<Role>
)