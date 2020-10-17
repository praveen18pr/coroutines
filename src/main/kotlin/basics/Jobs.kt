package basics

import kotlinx.coroutines.*

fun main() {

    println("before blocking...")
    var job1: Job? = null
    var job2: Job? = null

    runBlocking {
        job1 = launch {

            delay(300L)

            job2 = launch {
                delay(5000L) // OPERATION
            }
            job2?.invokeOnCompletion {
                println("Job 2 is completed ${it?.localizedMessage}")
            }
        }

        delay(500L)
        // job1?.cancel()

        job1?.invokeOnCompletion {
            println("The job 1 is completed")
        }
    }
}