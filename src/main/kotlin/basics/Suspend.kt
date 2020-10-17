package basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

var functionCalls = 0

fun main() {
    runBlocking {
        launch {
            val functionOne = functionOne()
            println("Function one res :$functionOne")
            val functionTwo = functionTwo()
            println("Function two res :$functionTwo")
        }
    }

    println("There were $functionCalls made during execution")
}

suspend fun functionOne(): Int {
    delay(3000L)
    functionCalls++
    println("Hi I am function 1")
    return functionCalls
}

suspend fun functionTwo(): Int {
    delay(300L)
    functionCalls++
    println("Hi I am function 2")
    return functionCalls
}