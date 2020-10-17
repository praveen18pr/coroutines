package basics

import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch(CoroutineName("myCoroutine")) {
            println(coroutineContext[CoroutineName.Key])
        }
    }
}