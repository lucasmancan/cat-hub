package br.com.lucasmancan

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories


@SpringBootApplication
@EnableR2dbcRepositories
@EntityScan("br.com.lucasmancan")
class CatReactiveServiceApplication

fun main(args: Array<String>) {
    runApplication<CatReactiveServiceApplication>(*args)
}
