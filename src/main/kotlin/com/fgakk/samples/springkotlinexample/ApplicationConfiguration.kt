package com.fgakk.samples.springkotlinexample

import com.fgakk.samples.springkotlinexample.entity.Article
import com.fgakk.samples.springkotlinexample.entity.User
import com.fgakk.samples.springkotlinexample.repository.ArticleRepository
import com.fgakk.samples.springkotlinexample.repository.UserRepository
import com.thedeanda.lorem.Lorem
import com.thedeanda.lorem.LoremIpsum
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {

    @Bean
    fun lorem() = LoremIpsum.getInstance();

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            articleRepository: ArticleRepository,
                            lorem: Lorem) = ApplicationRunner {

        val fgakk = userRepository.save(User(login = "fgakk", firstName = "Fatih", lastName = "Akkaya", email = "gucluakkaya@gmail.com"))
        val xgamer = userRepository.save(User(login = "xgamer", firstName = "XPerson", lastName = "Gamer", email = "xgamer@gmail.com"))
        // For each author save 50 articles
        for (i in 1..50) {
            articleRepository.save(
                    Article(
                            headline = lorem.getTitle(2, 4),
                            author = fgakk,
                            body = lorem.getParagraphs(1, 2)
            ))

            articleRepository.save(
                    Article(
                            headline = lorem.getTitle(2, 4),
                            author = xgamer,
                            body = lorem.getParagraphs(1, 2)
                    ))
        }
    }
}