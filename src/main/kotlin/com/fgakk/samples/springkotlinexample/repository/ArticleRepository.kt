package com.fgakk.samples.springkotlinexample.repository

import com.fgakk.samples.springkotlinexample.entity.Article
import org.springframework.data.repository.CrudRepository
import java.util.*

interface ArticleRepository : CrudRepository<Article, UUID> {
    fun findByHeadlineSlug(headlineSlug: String): Article?
    fun findAllByOrderByDateDesc(): Iterable<Article>
}