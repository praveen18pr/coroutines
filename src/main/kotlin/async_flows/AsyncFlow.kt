package async_flows

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {

    runBlocking {
        println("Waiting for prime numbers ....")
        val sendPrime = sendPrime()

        // this will cancel the co-routine
        withTimeoutOrNull(1000L) {
            sendPrime.collect {
                println("Collecting: $it")
            }
        }
    }

}

fun sendPrime(): Flow<Int> = flow {
    val primeList = listOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
    primeList.forEach {
        delay(it * 100L)
        emit(it)
    }
}