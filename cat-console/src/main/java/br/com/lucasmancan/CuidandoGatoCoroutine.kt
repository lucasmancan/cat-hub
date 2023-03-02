package br.com.lucasmancan

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis


object MainCoroutine {

    @OptIn(DelicateCoroutinesApi::class)
    @JvmStatic
    fun main(args: Array<String>) {

        val alberto = Gato("Alberto")


        val tempoExecucao = measureTimeMillis {
            runBlocking {

                launch(Dispatchers.Default) {

                    val child = launch {
                        try {
                            println("Child is running")
                            delay(Long.MAX_VALUE)
                        } finally {
                            println("Child is cancelled")
                        }
                    }

                     comprarArranhador()
                }

                launch {
                    pentear(alberto)
                }
            }
        }
        println("Cuidamos do ${alberto.nome} em $tempoExecucao ms.")


        Thread.sleep(5000)
    }

    private suspend fun comprarArranhador() {
        yield()

        println("Comprando arranhador..." + Thread.currentThread().name)

        delay(2000)

        println("Arranhador comprado..." + Thread.currentThread().name)
    }


    private suspend fun pentear(gato: Gato) {

        println("Penteando ${gato.nome}..." + Thread.currentThread().name)

        delay(2000)

        println("${gato.nome} penteado(a)." + Thread.currentThread().name)


    }
}
