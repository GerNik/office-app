package ru.gernik.app.office.service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.gernik.app.office.service.dto.User

@Service
class UserService {

    var log = LoggerFactory.getLogger(UserService::class.java)

    fun getUser() : User {
        log.info("getUserMethod is invoked")
        return User("Petya", "Petrov")
    }
}