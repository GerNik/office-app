package ru.gernik.app.office.controller

import org.springframework.web.bind.annotation.*
import ru.gernik.app.office.controller.dto.User

const val USERS = "users"
const val WEBSTORE = "webstore"

@RequestMapping(WEBSTORE)
@RestController
class UserController {

    @GetMapping(USERS)
    fun getUser(): User {
        return User("Ivan", "Ivanov")
    }

    @PostMapping
    fun addUser(@RequestBody user: User): User {
        return user
    }
}