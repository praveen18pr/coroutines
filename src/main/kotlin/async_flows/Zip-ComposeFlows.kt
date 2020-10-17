package async_flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        // zip()
        combine()
    }
}

private suspend fun combine() {
    val numbers = (1..5).asFlow().onEach { delay(300L) }
    val values = flowOf("One", "Two", "Three", "Four", "Five")

    val combine = numbers.combine(values) { a, b ->
        "$a matches $b"
    }
    combine.collect {
        println(it)
    }
}

private suspend fun zip() {
    val english = flowOf("One", "Two", "Three", "Four")
    val hindi = flowOf("Ek", "Do", "Teen", "Chaar")

    english.zip(hindi) { a, b ->
        "$a in French is $b"
    }.collect {
        println(it)
    }
}