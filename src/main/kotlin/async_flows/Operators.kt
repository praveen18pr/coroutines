package async_flows

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() {
    // runBlocking {
    // printNumberMap()
    // printNumberFilter()
    // printNumberTransform()
    // printFactorialUsingReduceOperator()
    // }
}

suspend fun printNumberMap() {
    (1..10).asFlow()
        .map {
            "Mapping to string $it"
        }.collect {
            println(it)
        }
}

suspend fun printNumberFilter() {
    println("--- Start of filter ---")
    (1..10).asFlow()
        .filter {
            it > 3
        }.collect {
            println(it)
        }
    println("--- End of filter ---")
}

suspend fun printNumberTransform() {
    println("--- Start of Transform ---")
    (1..10).asFlow()
        .transform {
            emit("Hello")
            emit(it)
        }.collect {
            println(it)
        }
    println("--- End of Tranform ---")
}

suspend fun printFactorialUsingReduceOperator() {
    println("--- Start of Reduce ---")
    val factorial = (1..5).asFlow()
        .flowOn(Dispatchers.IO)
        .reduce { accumulator, value ->
            accumulator * value
        }
    println("Factorial is $factorial")
    println("--- End of Reduce ---")
}