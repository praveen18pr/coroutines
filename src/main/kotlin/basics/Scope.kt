package basics

import kotlinx.coroutines.*

fun main() {

    println("blocking the thread...")
    println("Main Thread :${Thread.currentThread().name}")

    runBlocking {
        launch {
            delay(300L)
            println("Launch Thread :${Thread.currentThread().name}")
        }

        GlobalScope.launch {
            delay(500L)
            println("GLobal Scope Thread : ${Thread.currentThread().name}")
        }

        coroutineScope {
            delay(1000L)
            println("Coroutine scope Thread : ${Thread.currentThread().name}")
        }
    }

    println("unblocking the thread...")
}