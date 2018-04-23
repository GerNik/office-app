package ru.gernik.auth.service

import ru.gernik.auth.domain.User

interface UserService {

    fun saveUser(user: User): User
}