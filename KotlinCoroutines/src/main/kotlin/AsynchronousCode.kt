import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

// Structured Concurrency - code is sequential by default and cooperates with an underlying event loop
// This main function uses launch { }
//fun main() {
//    val time = measureTimeMillis {
//        runBlocking {
//            println("Weather Forecast")
//            launch {// Launch { } is a coroutine builder. It launches a new coroutine concurrently with the rest of code.
//                printForecast()
//            }
//            launch {
//                printTemperature()
//            }
//            println("Have a Good Day")
//        }
//    }
//    println("Executed time : ${time / 1000.0} seconds")
//}

private suspend fun printForecast() {
    delay(2000)
    println("Sunny")
}

private suspend fun printTemperature() {
    delay(3000)
    println("25\u00b0C")
}

// This main function uses async function which returns an object of type deferred
// To access the result on the deferred object using await()
fun main() {
    runBlocking {
        println("Weather Forecast")
        getWeatherReport()
        println("Have a Good Day")
    }
}

private suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

private suspend fun getTemperature(): String {
    delay(1000)
    return "30\u00b0C"
}

// Parallel Decomposition - It involves taking a problem and breaking it into smaller subtasks
// that can be solved in parallel.

private suspend fun getWeatherReport() = coroutineScope {
//    coroutine scope - it will only return once all its work, including any coroutines it launched, have completed
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }
    println("${forecast.await()} ${temperature.await()}")
}
