package ru.gernik.app.office.controller

import org.springframework.web.bind.annotation.*
import ru.gernik.app.office.service.UserService
import ru.gernik.app.office.service.dto.User

const val USERS = "users"
const val WEBSTORE = "webstore"

@RequestMapping(WEBSTORE)
@RestController
class UserController (private var userService : UserService) {

    @GetMapping(USERS)
    fun getUser() : User {
        return userService.getUser()
    }

    @PostMapping
    fun addUser(@RequestBody user: User): User {
        return user
    }
}