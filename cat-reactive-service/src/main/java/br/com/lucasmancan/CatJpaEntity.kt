package br.com.lucasmancan

import jakarta.persistence.Entity
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table


@Entity
@Table(name = "cats")
data class CatJpaEntity(
    @Id
    val id: Int? = null,
    val name: String? = null,
    val age: Int? = null
)