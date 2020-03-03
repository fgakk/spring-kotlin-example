package com.fgakk.samples.springkotlinexample.entity

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*

@Entity
data class NewsReport(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID,
        @Column
        val headline: String,
        @ManyToOne
        val author: User,
        @Column
        val date: LocalDateTime,
        @Column
        val body: String)