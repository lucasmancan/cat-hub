package br.com.lucasmancan.catmvcservice

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CatRepository : JpaRepository<CatJpaEntity, Long> {

}