package com.fgakk.samples.springkotlinexample.entity

import java.util.*
import javax.persistence.*

@Entity
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID? = null,
        @Column
        val login: String,
        @Column
        val firstName: String,
        @Column
        val lastName: String,
        @Column
        val email: String)