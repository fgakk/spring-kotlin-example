package com.fgakk.samples.springkotlinexample.entity

import java.util.*
import javax.persistence.*

@Entity
data class Comment(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID? = null,
        val author: String,
        val text: String,
        @OneToMany
        val replies: List<Comment>? = emptyList(),
        @ManyToOne
        val article: Article? = null
)