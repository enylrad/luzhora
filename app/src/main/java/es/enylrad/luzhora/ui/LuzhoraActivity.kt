package es.enylrad.luzhora.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import es.enylrad.luzhora.ui.theme.LuzhoraTheme


class MainActivity : AppCompatActivity() {

    val luzhoraViewModel by viewModels<LuzhoraViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initApp()
    }

    private fun initApp(){
        setContent {
            LuzhoraTheme {
                LuzhoraApp(luzhoraViewModel)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        luzhoraViewModel.startProcessCheckPrice()
    }

    override fun onPause() {
        super.onPause()
        luzhoraViewModel.pauseProcessCheckPrice()
    }
}

@Composable
private fun LuzhoraApp(luzhoraViewModel: LuzhoraViewModel) {
    val price = luzhoraViewModel.currentPrice.value
    MainBody(price)
}