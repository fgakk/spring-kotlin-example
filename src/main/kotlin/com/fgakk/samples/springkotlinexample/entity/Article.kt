package com.fgakk.samples.springkotlinexample.entity

import com.fgakk.samples.springkotlinexample.toSlug
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class Article(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID? = null,
        val headline: String,
        @ManyToOne
        val author: User,
        val date: LocalDateTime = LocalDateTime.now(),
        val headlineSlug: String = headline.toSlug(),
        @Column(length = 1023)
        val body: String)
