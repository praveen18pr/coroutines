package basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {

    GlobalScope.launch {
        delay(500L)
        println("Inside the global scope")
        println(Thread.currentThread().name)
    }

    Thread.sleep(1000L)
    println("End of execution")
}