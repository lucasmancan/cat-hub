package br.com.lucasmancan

import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

@Service
class CatService(val repository: CatRepository) {

    suspend fun findById(id: Long): CatJpaEntity? {
        return repository.findById(id)
    }

    fun findAll(): Flow<CatJpaEntity> {
        return repository.findAll()
    }

    suspend fun save(catJpaEntity: CatJpaEntity): CatJpaEntity {
        return repository.save(catJpaEntity)
    }
}