package es.enylrad.luzhora.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.enylrad.luzhora.data.model.Price
import es.enylrad.luzhora.data.util.getPrice
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class LuzhoraViewModel : ViewModel() {

    private var update: Boolean = false

    var currentPrice: MutableState<Price> = mutableStateOf(Price.Low())
        private set

    fun startProcessCheckPrice() {
        viewModelScope.launch {
            update = true
            while (update) {
                delay(TimeUnit.SECONDS.toMillis(1))
                currentPrice.value = getPrice()
            }
        }
    }

    fun pauseProcessCheckPrice() {
        update = false
    }
}