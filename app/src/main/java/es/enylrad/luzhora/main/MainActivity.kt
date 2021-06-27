package es.enylrad.luzhora.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import es.enylrad.luzhora.ui.LuzhoraTheme


class MainActivity : AppCompatActivity() {

    val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LuzhoraTheme {
                MainActivityScreen(mainViewModel)
            }
        }
        mainViewModel.startService(this)
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.startProcessCheckPrice()
    }

    override fun onPause() {
        super.onPause()
        mainViewModel.pauseProcessCheckPrice()
    }
}

@Composable
private fun MainActivityScreen(mainViewModel: MainViewModel) {
    MainScreen(mainViewModel.currentPrice.value)
}