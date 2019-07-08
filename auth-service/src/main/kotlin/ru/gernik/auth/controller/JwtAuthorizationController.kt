package ru.gernik.auth.controller

import io.swagger.annotations.ApiOperation
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.gernik.auth.configuration.util.JwtTokenUtils
import ru.gernik.auth.controller.model.AuthResponse
import ru.gernik.auth.controller.model.LoginRequest
import ru.gernik.auth.domain.UserDTO
import ru.gernik.auth.service.JwtUserDetailsService

@RestController
@CrossOrigin
class JwtAuthorizationController(private val userDetailsService: JwtUserDetailsService,
                                 private val authenticationManager: AuthenticationManager,
                                 private val jwtTokenUtils: JwtTokenUtils
) {

    @ApiOperation("Register new user")
    @PostMapping("/registration")
    fun register(@RequestBody user: UserDTO) {
        userDetailsService.saveUser(user)
    }

    @ApiOperation("Login")
    @PostMapping("/login")
    fun login(@RequestBody @Validated request: LoginRequest): AuthResponse {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(request.login, request.password))
        val userDetails = userDetailsService.loadUserByUsername(request.login)
        val accessToken = jwtTokenUtils.generateToken(userDetails)
        return AuthResponse(accessToken, "token")
    }
}