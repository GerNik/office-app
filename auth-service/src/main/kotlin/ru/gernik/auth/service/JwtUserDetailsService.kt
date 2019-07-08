package ru.gernik.auth.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import ru.gernik.auth.domain.UserDTO
import ru.gernik.auth.repository.UserRepository
import ru.gernik.auth.repository.entity.UserEntity

@Service
class JwtUserDetailsService(private val userRepository: UserRepository,
                            private val passwordEncoder: PasswordEncoder
) : UserDetailsService {

    fun saveUser(user: UserDTO) {
        val optionalUser = userRepository.findByLogin(user.login)
        if (optionalUser.isPresent) {
            throw RuntimeException("User with login: ${user.login} already exist")
        }
        userRepository.save(UserEntity(null,
                user.login,
                passwordEncoder.encode(user.password),
                user.name,
                user.surname,
                user.middleName,
                user.email,
                user.phoneNumber,
                emptyList()
        ))

    }

    override fun loadUserByUsername(userLogin: String): UserDetails {
        val optionalUser = userRepository.findByLogin(userLogin)
        if (optionalUser.isPresent) {
            val user = optionalUser.get()
            return User(user.login, user.password, emptyList())
        } else {
            throw UsernameNotFoundException("UserDTO not found with login: $userLogin")
        }
    }
}