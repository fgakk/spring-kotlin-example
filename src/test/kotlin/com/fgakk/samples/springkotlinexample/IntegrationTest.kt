package com.fgakk.samples.springkotlinexample

import com.fgakk.samples.springkotlinexample.entity.Article
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.boot.test.web.client.getForEntity

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests(@Autowired val restTemplate: TestRestTemplate) {
    @Test
    fun `Assert blog page title, content and status code`() {
        println(">> Assert blog page title, content and sstatus code")
        val author = "fgakk"
        val entity = restTemplate.getForEntity<String>("/api/articles/")
        assertThat(entity.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(entity.body).contains(author)
    }
}