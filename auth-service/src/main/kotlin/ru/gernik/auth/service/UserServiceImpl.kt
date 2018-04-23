package ru.gernik.auth.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.gernik.auth.domain.User
import ru.gernik.auth.repository.UserRepository

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun saveUser(user: User): User = userRepository.save(user)
}