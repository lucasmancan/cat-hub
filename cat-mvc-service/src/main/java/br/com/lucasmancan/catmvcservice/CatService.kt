package br.com.lucasmancan.catmvcservice

import br.com.lucasmancan.CatJpaEntity
import org.springframework.stereotype.Service

@Service
class CatService(val repository: CatRepository) {

    fun findById(id: Long): CatJpaEntity? {
        return repository.findById(id).orElse(null)
    }

    fun findAll(): MutableList<CatJpaEntity> {
        return repository.findAll()
    }

    fun save(catJpaEntity: CatJpaEntity): CatJpaEntity {
        return repository.save(catJpaEntity)
    }
}