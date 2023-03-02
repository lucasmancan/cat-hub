package br.com.lucasmancan

import kotlinx.coroutines.*

fun main() {
    runBlocking {
        println("Weather forecast")

        val job = launch {
            printForecast()
        }
        launch {
            printTemperature()
        }
        // Cancel the coroutine that fetches weather forecast data
        delay(200)
//        job.cancel()
        job.join()

    }
}

suspend fun printForecast() {
    delay(1000)
    println("Sunny")
}

suspend fun printTemperature() {
    delay(1000)
    println("30\u00b0C")
}