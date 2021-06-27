package es.enylrad.luzhora.util

import es.enylrad.luzhora.main.Price
import java.util.*

fun getPrice(): Price {

    val currentDate = Calendar.getInstance()

    return when (currentDate.get(Calendar.DAY_OF_WEEK)) {
        Calendar.SATURDAY, Calendar.SUNDAY -> {
            Price.Low()
        }
        else -> {
            getPriceHour(currentDate)
        }
    }
}

private fun getPriceHour(currentDate: Calendar): Price {
    val hour = currentDate.get(Calendar.HOUR_OF_DAY)
    return when {
        Price.Low().hours.contains(hour) -> {
            Price.Low()
        }
        Price.Medium().hours.contains(hour) -> {
            Price.Medium()
        }
        Price.High().hours.contains(hour) -> {
            Price.High()
        }
        else -> {
            Price.Low()
        }
    }
}