package ru.gernik.auth.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.gernik.auth.domain.User

@Repository
interface UserRepository : CrudRepository<User, String>