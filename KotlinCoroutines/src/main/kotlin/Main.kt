import kotlinx.coroutines.*

fun main() = runBlocking {
    launch {// Launch { } is a coroutine builder. It launches a new coroutine concurrently with the rest of code.
        delay(2000)// delay() - special suspending function. It suspends the coroutine for a specific time.
        println("World")
        myName()
    }
    println("Hello")
}

suspend fun myName() {
    delay(5000)
    println("Jeffry")
}