package br.com.lucasmancan

import javax.persistence.*


@Entity
@Table(name = "cats")
class CatJpaEntity(
    @Id
    @GeneratedValue
    val id: Long? = null,
    val name: String? = null,
    val age: Int? = null,
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
    val kittens: Set<CatJpaEntity>? = null
)