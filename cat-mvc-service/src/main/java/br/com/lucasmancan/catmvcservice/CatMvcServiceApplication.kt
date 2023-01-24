package br.com.lucasmancan.catmvcservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories


@SpringBootApplication
@EnableJpaRepositories
@EntityScan("br.com.lucasmancan")
class CatMvcServiceApplication

fun main(args: Array<String>) {
	runApplication<CatMvcServiceApplication>(*args)
}
