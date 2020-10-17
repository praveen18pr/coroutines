package async_flows

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val printNumbersInFlow = printNumbersInFlow()
        printNumbersInFlow.collect {
             println(it)
        }
    }
}

suspend fun printNumbersInFlow() = flow {
    val asFlow = (1..5).asFlow()
    asFlow.collect {
        println("it $it")
         emit(it)
        // emit("LALALALALALALA")
        // emit("HELLO")
    }
}