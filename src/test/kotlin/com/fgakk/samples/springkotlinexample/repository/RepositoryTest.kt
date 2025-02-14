package com.fgakk.samples.springkotlinexample.repository

import com.fgakk.samples.springkotlinexample.entity.Article
import com.fgakk.samples.springkotlinexample.entity.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull
import java.time.LocalDateTime

@DataJpaTest
class RepositoryTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val userRepository: UserRepository,
        val articleRepository: ArticleRepository) {

    @Test
    fun `When findByIdOrNull then return Article`() {
        val user = User( login = "fgakk", firstName = "Fatih", lastName = "Akkaya", email = "gucluakkaya@gmail.com")
        entityManager.persist(user)
        val article = Article(headline = "PS5 is comming soon", author = user, date = LocalDateTime.now(), body = "Lorem ipsum")
        entityManager.persist(article)
        entityManager.flush()
        val found = articleRepository.findByIdOrNull(article.id!!)
        assertThat(found).isEqualTo(article)
    }

    @Test
    fun `When findByLogin then return User`() {
        val user = User(login = "fgakk", firstName = "Fatih", lastName = "Akkaya", email = "gucluakkaya@gmail.com")
        entityManager.persist(user)
        entityManager.flush()
        val foundUser = userRepository.findByLogin(user.login)
        assertThat(user).isEqualTo(foundUser)
    }
}