package ru.gernik.app.office.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.gernik.app.office.controller.dto.User

const val USERS = "/users"

@RestController
class UserController {

    @GetMapping(USERS)
    fun getUser(): User{
        return User("Ivan", "Ivanov")
    }
}