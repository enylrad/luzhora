package es.enylrad.luzhora.main

import androidx.lifecycle.ViewModel
import es.enylrad.luzhora.util.getPrice
import java.util.*
import java.util.Calendar.SATURDAY
import java.util.Calendar.SUNDAY

class MainViewModel : ViewModel() {

    val currentPrice: Price
        get() = getPrice()

}