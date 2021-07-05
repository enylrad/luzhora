package es.enylrad.luzhora

import android.app.Application
import es.enylrad.luzhora.common.notification.launchNotificationPrice
import es.enylrad.luzhora.data.util.programAlarm


class LuzhoraApp : Application() {

    override fun onCreate() {
        super.onCreate()

        launchNotificationPrice()
        programAlarm()
    }
}