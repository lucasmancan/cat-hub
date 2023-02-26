package br.com.lucasmancan

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CatRepository : CoroutineCrudRepository<CatJpaEntity, Long> {

}