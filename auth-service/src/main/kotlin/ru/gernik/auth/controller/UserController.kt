package ru.gernik.auth.controller

import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*
import ru.gernik.auth.domain.UserDTO
import ru.gernik.auth.service.UserService

const val USERS = "users"

@RequestMapping(USERS)
@RestController
class UserController(val userService: UserService) {

    @ApiOperation("Get user info  by user id")
    @GetMapping("/{id}")
    fun getUserById(@RequestParam("id")id: String) : UserDTO = userService.getUserById(id)
}