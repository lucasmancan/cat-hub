package br.com.lucasmancan.catmvcservice

import br.com.lucasmancan.CatJpaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CatRepository : JpaRepository<CatJpaEntity, Long> {

}