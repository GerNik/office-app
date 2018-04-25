package ru.gernik.auth.controller

import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import ru.gernik.auth.BaseSpec
import ru.gernik.auth.repository.UserRepository

class UserControllerSpec : BaseSpec() {

    @Autowired
    lateinit var userRepository: UserRepository

    @Test
    fun test(){
        assert(true)
    }
}
