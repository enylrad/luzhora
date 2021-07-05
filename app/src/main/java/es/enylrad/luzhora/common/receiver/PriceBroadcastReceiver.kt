package es.enylrad.luzhora.common.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import es.enylrad.luzhora.common.notification.launchNotificationPrice


class PriceBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.launchNotificationPrice()
    }
}