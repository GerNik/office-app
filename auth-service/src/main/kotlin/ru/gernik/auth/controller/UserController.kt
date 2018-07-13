package ru.gernik.auth.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.gernik.auth.domain.User
import ru.gernik.auth.service.UserService
import java.security.Principal

const val USERS = "users"

@RequestMapping(USERS)
@RestController
class UserController {

    @Autowired
    lateinit var userService: UserService

    @PostMapping
    fun saveUser(@RequestBody user: User): User = userService.saveUser(user)

    @GetMapping("/current")
    fun getUserInfo(principal: Principal) : Principal = principal
}