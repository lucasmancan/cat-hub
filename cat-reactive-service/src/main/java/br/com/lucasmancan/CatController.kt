package br.com.lucasmancan

import kotlinx.coroutines.flow.Flow
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/cats")
class CatController(private val catService: CatService) {

    @GetMapping("{id}")
    suspend fun findById(@PathVariable("id") id: Long): ResponseEntity<Any> {

        val cat = catService.findById(id)

        return if (cat != null) {
            ResponseEntity.ok(cat)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping()
    fun findAll(): Flow<CatJpaEntity> {
        return catService.findAll()
    }

    @PostMapping
    suspend fun save(@RequestBody catJpaEntity: CatJpaEntity): CatJpaEntity {
        val cat = catService.save(catJpaEntity)

        println("Gato cadastrado no serviço reativo ${cat.id}")
        return cat
    }
}