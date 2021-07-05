package es.enylrad.luzhora.data.model

import androidx.annotation.ColorRes
import androidx.annotation.RawRes
import androidx.annotation.StringRes
import es.enylrad.luzhora.R

sealed class Price(
    val hours: List<Int>,
    @StringRes val type: Int,
    @ColorRes val color: Int,
    @RawRes val lottieAnim: Int
) {
    class High : Price(
        hours = listOf(10, 11, 12, 13, 18, 19, 20, 21),
        type = R.string.high,
        color = R.color.red,
        lottieAnim = R.raw.lottie_high
    )

    class Medium : Price(
        hours = listOf(8, 9, 14, 15, 16, 17, 22, 23),
        type = R.string.medium,
        color = R.color.yellow,
        lottieAnim = R.raw.lottie_medium
    )

    class Low : Price(
        hours = listOf(0, 1, 2, 3, 4, 5, 6, 7),
        type = R.string.low,
        color = R.color.green,
        lottieAnim = R.raw.lottie_low
    )
}