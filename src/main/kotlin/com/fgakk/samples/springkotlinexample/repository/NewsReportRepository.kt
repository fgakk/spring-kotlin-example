package com.fgakk.samples.springkotlinexample.repository

import com.fgakk.samples.springkotlinexample.entity.NewsReport
import com.fgakk.samples.springkotlinexample.entity.User
import org.springframework.data.repository.CrudRepository
import java.util.*

interface NewsReportRepository: CrudRepository<NewsReport, UUID> {
    fun findByAuthor(author: User)
}