package es.enylrad.luzhora.util

import android.os.Build
import java.text.SimpleDateFormat
import java.util.*


fun supportsOreo(code: () -> Unit) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        code()
    }
}