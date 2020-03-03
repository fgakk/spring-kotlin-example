package com.fgakk.samples.springkotlinexample.repository

import com.fgakk.samples.springkotlinexample.entity.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface UserRepository: CrudRepository<User, UUID> {
    fun findByLogin(login: String): User?
}