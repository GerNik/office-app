package ru.gernik.auth.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.gernik.auth.repository.entity.UserEntity
import java.util.*

@Repository
interface UserRepository : CrudRepository<UserEntity, String> {

    fun findByLogin(login: String): Optional<UserEntity>
}