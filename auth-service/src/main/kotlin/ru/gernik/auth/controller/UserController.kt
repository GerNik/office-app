package ru.gernik.auth.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.gernik.auth.domain.User
import ru.gernik.auth.service.UserService
import java.security.Principal

const val USERS = "users"

@RequestMapping(USERS)
@RestController
class UserController {

    lateinit var userService: UserService

    @PostMapping
    fun saveUser(user: User): User = userService.saveUser(user)

    @GetMapping("/current")
    fun getUserInfo(principal: Principal) : Principal = principal
}