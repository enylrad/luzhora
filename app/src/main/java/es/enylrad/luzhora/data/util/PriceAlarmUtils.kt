package es.enylrad.luzhora.data.util

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import es.enylrad.luzhora.common.receiver.PriceBroadcastReceiver
import java.util.*


fun Context.programAlarm() {

    val calendar = Calendar.getInstance().apply {
        add(Calendar.HOUR_OF_DAY, 1)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 1)
        set(Calendar.MILLISECOND, 0)
    }

    val intent = Intent(this, PriceBroadcastReceiver::class.java)
    val alarmIntent = PendingIntent.getBroadcast(
        this,
        0,
        intent,
        PendingIntent.FLAG_UPDATE_CURRENT
    )

    val alarmManager = getSystemService(AppCompatActivity.ALARM_SERVICE) as AlarmManager

    alarmManager.setRepeating(
        AlarmManager.RTC_WAKEUP,
        calendar.timeInMillis,
        AlarmManager.INTERVAL_HOUR,
        alarmIntent
    )
}