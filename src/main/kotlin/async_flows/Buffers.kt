package async_flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {

        val timeTaken = measureTimeMillis {
            printNumbers()
                .buffer()
                .collect {
                    delay(300L) // operation delay
                    println("inside collect: $it")
                }
        }
        println("Time taken: $timeTaken")
    }
}

fun printNumbers() = flow {
    for (i in 1..10) {
        delay(100L) // operation delay
        println("Printing number with delay: $i")
        emit(i)
    }
}