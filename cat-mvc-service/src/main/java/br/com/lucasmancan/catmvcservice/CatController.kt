package br.com.lucasmancan.catmvcservice

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/cats")
class CatController(private val catService: CatService) {

    @GetMapping("{id}")
    fun findById(@PathVariable("id") id: Long): ResponseEntity<Any> {

        val cat = catService.findById(id)

        return if (cat != null) {
            ResponseEntity.ok(cat)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping()
    fun findAll(): List<CatJpaEntity> {
        return catService.findAll()
    }

    @PostMapping
    fun save(@RequestBody catJpaEntity: CatJpaEntity): CatJpaEntity {
        return catService.save(catJpaEntity)
    }
}