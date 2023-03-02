package br.com.lucasmancan

import kotlin.system.measureTimeMillis


object Main {

    @JvmStatic
    fun main(args: Array<String>) {

        val alberto = Gato("Alberto")

        val tempoExecucao = measureTimeMillis {

            comprarArranhador()

            pentear(alberto)

        }

        println("Cuidamos do ${alberto.nome} em $tempoExecucao ms.")
    }

    private fun comprarArranhador() {
        println("Comprando arranhador...")

        Thread.sleep(2000)

        println("Arranhador comprado...")
    }


    private fun pentear(gato: Gato) {

        println("Penteando ${gato.nome}...")

        Thread.sleep(2000)

        println("${gato.nome} penteado(a).")
    }
}
