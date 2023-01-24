package br.com.lucasmancan


data class Cat(
    val id: Long,
    val name: String,
    val age: Int,
    val kittens: Set<Cat> = mutableSetOf()
)