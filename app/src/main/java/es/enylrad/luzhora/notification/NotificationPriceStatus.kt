package es.enylrad.luzhora.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import es.enylrad.luzhora.R
import es.enylrad.luzhora.main.Price
import es.enylrad.luzhora.util.getPrice
import es.enylrad.luzhora.util.supportsOreo

const val ID_NOTIFICATION_PRICE = 1

fun Context.launchNotificationPrice() {
    val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

    val price = getPrice()
    val notification = notificationManager?.createNotificationPrice(this, price)
    notificationManager?.notify(ID_NOTIFICATION_PRICE, notification)
}

private fun NotificationManager.createNotificationPrice(
    context: Context,
    price: Price
): Notification {

    val channelId = context.getString(R.string.channel_id)

    supportsOreo {
        val channelTitle = context.getString(R.string.channel_title)
        val channelDescription = context.getString(R.string.channel_description)
        val channelImportance = NotificationManager.IMPORTANCE_MIN
        val channel = NotificationChannel(channelId, channelTitle, channelImportance).apply {
            description = channelDescription
            importance = channelImportance
            name = channelTitle
            description = channelDescription
            setShowBadge(false)
        }

        createNotificationChannel(channel)
    }

    return NotificationCompat.Builder(context, channelId)
        .setSmallIcon(R.drawable.ic_notification)
        .setContentTitle(context.getString(price.type))
        .setPriority(NotificationCompat.PRIORITY_MIN)
        .setCategory(NotificationCompat.CATEGORY_SERVICE)
        .setColor(context.getColor(price.color))
        .setLocalOnly(true)
        .setOnlyAlertOnce(true)
        .setShowWhen(true)
        .setAutoCancel(false)
        .setOngoing(true)
        .build()
}