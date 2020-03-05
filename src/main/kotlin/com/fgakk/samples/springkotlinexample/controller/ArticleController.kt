package com.fgakk.samples.springkotlinexample.controller

import com.fgakk.samples.springkotlinexample.entity.Comment
import com.fgakk.samples.springkotlinexample.repository.ArticleRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/api/articles")
class ArticleController(private val repository: ArticleRepository) {

    @GetMapping("/")
    fun findAll() = repository.findAllByOrderByDateDesc()

    @GetMapping("/{slug}")
    fun findOne(@PathVariable slug: String) =
            repository.findByHeadlineSlug(slug)
                    ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")

    @PostMapping("/{id}/comment")
    fun addComment(@PathVariable id: UUID, @RequestBody comment: Comment) {
        val article = repository
                .findByIdOrNull(id)
                ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "This article does not exist")
        val updated = article.copy(comments = article.comments.plus(comment))
        repository.save(updated)
    }
}