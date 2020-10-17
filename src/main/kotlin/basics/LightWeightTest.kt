package basics

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    println(Thread.currentThread().name + " id : " + Thread.currentThread().id)
    println("before")
    runBlocking {
        repeat(1_000_000) {
            launch {
                println(".")
                println(Thread.currentThread().name + " id : " + Thread.currentThread().id)
            }
        }
    }


}
