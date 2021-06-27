package es.enylrad.luzhora.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationSpec
import com.airbnb.lottie.compose.rememberLottieAnimationState
import es.enylrad.luzhora.ui.LuzhoraTheme

@Composable
fun MainScreen(price: Price) {
    Scaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = stringResource(price.type),
                style = TextStyle(fontSize = 25.sp)
            )

            val animationSpec = remember { LottieAnimationSpec.RawRes(price.lottieAnim) }
            val animationState = rememberLottieAnimationState(
                autoPlay = true,
                repeatCount = Integer.MAX_VALUE
            )
            LottieAnimation(
                spec = animationSpec,
                modifier = Modifier.size(300.dp),
                animationState = animationState
            )
        }
    }
}

@Preview
@Composable
fun LayoutPreview() {
    LuzhoraTheme {
        MainScreen(Price.Low())
    }
}