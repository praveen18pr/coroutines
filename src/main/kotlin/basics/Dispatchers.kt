package basics

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    runBlocking {

//        launch(Dispatchers.Main) {
//            println("Main thread .... ${Thread.currentThread().name}")
//        }

        launch(Dispatchers.Unconfined) {
            println("Unconfined. ${Thread.currentThread().name}")
            delay(500L)
            println("Unconfined. ${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default) {
            println("Default. ${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO. ${Thread.currentThread().name}")
            // val res = makeAPICall()

            // if(res.isSuccessful){
            // withContext(Dispatchers.Main) {
            // UI thread
            // Update the UI
            // View Model
            // }
            // }
        }
    }
}