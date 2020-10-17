package channels

import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {
        
        val channel = produce {
            for (i in 1..5) {
                send(i * i)
            }
        }

        for (y in channel) {
            println(channel.receive())
        }

    }
}