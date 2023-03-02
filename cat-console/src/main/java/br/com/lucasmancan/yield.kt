package br.com.lucasmancan

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        val job = launch {
            val child = launch {
                try {
                    println("Child is running")
                    delay(Long.MAX_VALUE)
                } finally {
                    println("Child is cancelled")
                }
            }

            yield() // without this, child job doesn't get executed
            println("Cancelling child")
            child.cancel()
            child.join()
            println("Parent is not cancelled")
        }
        println("Parent is running")
        job.join()
    }
}