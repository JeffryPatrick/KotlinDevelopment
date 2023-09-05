import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// Exception - an unexpected event that happens during execution of your code.
// Used to prevent app from crashing and impacting the user experience negatively
//fun main() {
//    val numberOfPeople = 0
//    val numberOfPizzas = 20
//    println("Slices per person: ${numberOfPizzas / numberOfPeople}")
//}
// To avoid this, use try catch exceptions
/**
 * try {
 *      // some code that may throw an exception
 * } catch(e: IllegalArgumentException) {
 *      // Handle exception
 * }
 */
fun main(args: Array<String>) {
    runBlocking {
        println("Weather Forecast")
        println(getWeatherReport())
        println("Have a good day!")
    }
}

//private suspend fun getWeatherReport() = coroutineScope {
////    coroutine scope - it will only return once all its work, including any coroutines it launched, have completed
//    val forecast = async { getForecast() }
//    val temperature = async {
//        try {
//            getTemperature()
//        } catch (e: AssertionError) {
//            println("Caught exception $e")
//            "{ No temperature found }"
//        }
//
//    }
//    "${forecast.await()} ${temperature.await()}"
//}

private suspend fun getForecast(): String {
    delay(1000)
    return "Sunny"
}

//private suspend fun getTemperature(): String {
//    delay(1000)
//    throw AssertionError("Temperature is invalid")
//    return "30\u00b0C"
//}

// ---------------------------------------------------------------------------------------
// Cancellation - it is typically user-driven when an event has caused the app to cancel
// work that it had previously started

private suspend fun getWeatherReport() = coroutineScope {
//    coroutine scope - it will only return once all its work, including any coroutines it launched, have completed
    val forecast = async { getForecast() }
    val temperature = async { getTemperature() }

    delay(2000)
    temperature.cancel()
    "${forecast.await()}"
}

private suspend fun getTemperature(): String {
    delay(1000)
    return "30\u00b0C"
}