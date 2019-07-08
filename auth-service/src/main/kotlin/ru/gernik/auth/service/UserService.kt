package ru.gernik.auth.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.gernik.auth.domain.UserDTO
import ru.gernik.auth.repository.UserRepository

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun getUserById(id: String): UserDTO {
        val user = userRepository.findById(id).get()
        return UserDTO(user.id,
                user.login,
                user.password,
                user.name,
                user.surname,
                user.middleName,
                user.email,
                user.phoneNumber,
                user.roles
        )
    }

}