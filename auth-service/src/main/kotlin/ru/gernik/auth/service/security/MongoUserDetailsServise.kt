package ru.gernik.auth.service.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import ru.gernik.auth.domain.CustomUserDetails
import ru.gernik.auth.repository.UserRepository

@Service
class MongoUserDetailsServise : UserDetailsService {
    @Autowired
    lateinit var userRepository: UserRepository

    override fun loadUserByUsername(username: String): UserDetails {
        return CustomUserDetails(userRepository.findByLogin(username))
    }
}