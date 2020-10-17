package basics

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {

    runBlocking {
        val firstDeferred = async { firstValue() }

        println("Waiting for the values")
        delay(500L)

        val firstValue = firstDeferred.await()
        val secondDeferred = async { secondValue(firstValue) }
        val total = secondDeferred.await()

        println("The values are $total")
    }
}

suspend fun firstValue(): Int {
    delay(1000L)
    val value = Random.nextInt(500)
    println("First Value: $value")
    return value
}

suspend fun secondValue(firstValue: Int): Int {
    delay(2000L)
    var value = Random.nextInt(5000)
    println("Second Value: $value")
    value += firstValue
    return value
}
