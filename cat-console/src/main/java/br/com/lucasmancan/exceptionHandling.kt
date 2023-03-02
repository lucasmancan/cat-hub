package br.com.lucasmancan

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.*

@OptIn(DelicateCoroutinesApi::class)
fun mainSemHandler() = runBlocking {
    val job = GlobalScope.launch { // root coroutine with launch
        println("Throwing exception from launch")
        throw IndexOutOfBoundsException() // Will be printed to the console by Thread.defaultUncaughtExceptionHandler
    }
    job.join()
    println("Joined failed job")
    val deferred = GlobalScope.async { // root coroutine with async
        println("Throwing exception from async")
        throw ArithmeticException() // Nothing is printed, relying on user to call await
    }
    try {
        deferred.await()
        println("Unreached")
    } catch (e: ArithmeticException) {
        println("Caught ArithmeticException")
    }
}

@OptIn(DelicateCoroutinesApi::class)
fun main1() = runBlocking {

    val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
        print("Ocorreu um erro : ${throwable.message}")
    }

    val scope =  CoroutineScope(Dispatchers.Default + handler).launch {
        supervisorScope {
            launch { // root coroutine with launch
                println("Executando tarefa com erro")
                throw IndexOutOfBoundsException() // Will be printed to the console by Thread.defaultUncaughtExceptionHandler
            }

            launch { // root coroutine with async
                println("Executando tarefa sem erro")
            }
        }
    }

    delay(10000)
}

@OptIn(DelicateCoroutinesApi::class)
fun main() = runBlocking {

    val handler = CoroutineExceptionHandler { coroutineContext, throwable ->
        print("Ocorreu um erro : ${throwable.message}")
    }

    val scope =  CoroutineScope(Dispatchers.Default + handler).launch {
        val job = launch { // root coroutine with launch
            println("Throwing exception from launch")
            throw IndexOutOfBoundsException() // Will be printed to the console by Thread.defaultUncaughtExceptionHandler
        }

        val deferred = async { // root coroutine with async
            println("Throwing exception from async")
            throw ArithmeticException() // Nothing is printed, relying on user to call await
        }
        try {
            deferred.await()
            println("Unreached")
        } catch (e: ArithmeticException) {
            println("Caught ArithmeticException")
        }

    }



    delay(10000)
}