import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    val time = measureTimeMillis {
        runBlocking {// runBlocking { } - is synchronous; it will not return until all work within its lambda block is completed
            println("Weather Forecast")
            printForecast()
            printTemperature()
        }
    }
    println("Executed time : ${time / 1000.0} seconds")
}

private suspend fun printForecast() { // suspend keyword used to change the function type as suspend
    delay(2000) // delay() - special suspending function. It suspends the coroutine for a specific time.
    println("Sunny")
}

private suspend fun printTemperature() {
    delay(3000)
    println("30\u00b0C") // \u00b0 - used to print the degree symbol
}