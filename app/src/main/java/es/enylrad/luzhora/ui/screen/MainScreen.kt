package es.enylrad.luzhora.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.*
import es.enylrad.luzhora.R
import es.enylrad.luzhora.data.model.Price
import es.enylrad.luzhora.ui.theme.LuzhoraTheme

@Composable
fun MainBody(price: Price) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                text = stringResource(price.type),
                style = TextStyle(fontSize = 25.sp)
            )
            AnimationPrice(price)
            Text(
                text = stringResource(id = R.string.animated_by_s, "Waalled Hasmi"),
                style = TextStyle(fontSize = 12.sp, fontStyle = FontStyle.Italic)
            )
        }
    }
}

@Composable
private fun AnimationPrice(price: Price) {

    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(price.lottieAnim))
    val progress by animateLottieCompositionAsState(
        composition = composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composition,
        modifier = Modifier.size(300.dp),
        progress = progress,
    )
}

@Preview
@Composable
fun AnimationPricePreview() {
    LuzhoraTheme {
        AnimationPrice(Price.Low())
    }
}

@Preview
@Composable
fun MainBodyPreview() {
    LuzhoraTheme {
        MainBody(Price.Low())
    }
}