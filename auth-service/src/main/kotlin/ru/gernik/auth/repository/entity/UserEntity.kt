package ru.gernik.auth.repository.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import ru.gernik.auth.domain.Role

@Document
data class UserEntity(
        @Id
        val id: String?,
        @Indexed(unique = true)
        val login: String,
        val password: String,
        val name: String,
        val surname: String,
        val middleName: String?,
        val email: String,
        val phoneNumber: String?,
        val roles: List<Role>
)