package es.enylrad.luzhora.main

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.enylrad.luzhora.notification.launchNotificationPrice
import es.enylrad.luzhora.util.getPrice
import es.enylrad.luzhora.util.programAlarm
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

class MainViewModel : ViewModel() {

    private var update:Boolean = false

    var currentPrice: MutableState<Price> = mutableStateOf(Price.Low())
        private set

    fun startService(context: Context) {
        context.launchNotificationPrice()
        context.programAlarm()
    }

    fun startProcessCheckPrice() {
        viewModelScope.launch {
            update = true
            while (update) {
                delay(TimeUnit.SECONDS.toMillis(1))
                val price = getPrice()
                currentPrice.value = price
            }
        }
    }

    fun pauseProcessCheckPrice() {
        update = false
    }

}