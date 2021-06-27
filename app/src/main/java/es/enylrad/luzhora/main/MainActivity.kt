package es.enylrad.luzhora.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import es.enylrad.luzhora.ui.LuzhoraTheme
import es.enylrad.luzhora.notification.launchNotificationPrice
import es.enylrad.luzhora.util.programAlarm


class MainActivity : AppCompatActivity() {

    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuzhoraTheme {
                MainActivityScreen(mainViewModel)
            }
        }

        launchNotificationPrice()
        programAlarm()
    }
}

@Composable
private fun MainActivityScreen(mainViewModel: MainViewModel) {
    MainScreen(mainViewModel.currentPrice)
}