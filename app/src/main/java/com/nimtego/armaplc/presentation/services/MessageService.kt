package com.nimtego.armaplc.presentation.services

import android.R
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.os.IBinder
import android.provider.CalendarContract.Events
import com.nimtego.armaplc.presentation.ui.activity.AppActivity
import java.util.*
import java.util.regex.Pattern


class MessageService : Service() {

//    override fun onBind(intent: Intent): IBinder {
//        TODO("Return the communication channel to the service.")
//    }
//
//    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
//        val sms_body = intent.extras!!.getString("sms_body")
//        showNotification(sms_body)
//        return Service.START_STICKY
//    }
//
//    private fun showNotification(text: String) {
//        val contentIntent = PendingIntent.getActivity(this, 0, Intent(this, AppActivity::class.java), 0)
//        val context = applicationContext
//        val builder = Notification.Builder(context)
//            .setContentTitle("Rugball")
//            .setContentText(text)
//            .setContentIntent(contentIntent)
//            .setSmallIcon(R.drawable.alert_dark_frame)
//            .setAutoCancel(true)
//        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//        val notification = builder.getNotification()
//        notificationManager.notify(R.drawable.alert_dark_frame, notification)
//    }

    private inner class SmsData {
        var hh: Int = 0
        var mm: Int = 0
        var description: String? = null
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    private fun showNotification(text: String?) {
        val contentIntent = PendingIntent.getActivity(this, 0, Intent(this, AppActivity::class.java), 0)
        val context = applicationContext
        val builder = Notification.Builder(context)
            .setContentTitle("Регбол")
            .setContentText(text)
            .setContentIntent(contentIntent)
            .setSmallIcon(R.drawable.alert_dark_frame)
            .setAutoCancel(true)
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notification = builder.getNotification()
        notificationManager.notify(R.drawable.alert_dark_frame, notification)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        val sms_body = intent.extras!!.getString("sms_body")
        showNotification(sms_body)
        saveSms(sms_body)

        val event = processSms(sms_body)
        if (event != null) {
            addEvent(event.hh, event.mm, event.description)
        }

        return Service.START_STICKY
    }

    private fun saveSms(sms_body: String?) {
        val now = Date()
        val now_long = now.getTime()

//        val values = ContentValues()
//        values.put(SmsTable.COLUMN_DATE, now_long)
//        values.put(SmsTable.COLUMN_TEXT, sms_body)
//
//        contentResolver.insert(SmsContentProvider.CONTENT_URI, values)
    }

    private fun processSms(sms_body: String?): SmsData? {
        val pattern = Pattern.compile("Регбол! Сегодня в (\\d+)-(\\d+). (.+)")
        if (pattern.matcher(sms_body).matches()) {
            val matcher = pattern.matcher(sms_body)
            matcher.find()
            val data = SmsData()
            data.hh = Integer.parseInt(matcher.group(1))
            data.mm = Integer.parseInt(matcher.group(2))
            data.description = matcher.group(3)
            return data
        }
        return null
    }

    private fun addEvent(hh: Int, mm: Int, description: String?) {
        val calId: Long = 1
        var startMillis: Long = 0
        var endMillis: Long = 0

        val beginTime = Calendar.getInstance()
        beginTime.set(Calendar.HOUR_OF_DAY, hh)
        beginTime.set(Calendar.MINUTE, mm)
        startMillis = beginTime.getTimeInMillis()

        val endTime = Calendar.getInstance()
        endTime.set(Calendar.HOUR_OF_DAY, hh + 2)
        endTime.set(Calendar.MINUTE, mm)
        endMillis = endTime.getTimeInMillis()

        val cr = contentResolver
        val values = ContentValues()
        values.put(Events.DTSTART, startMillis)
        values.put(Events.DTEND, endMillis)
        values.put(Events.TITLE, "Rugball")
        values.put(Events.DESCRIPTION, description)
        values.put(Events.CALENDAR_ID, calId)
        values.put(Events.EVENT_TIMEZONE, "Asia/Yekaterinburg")
        cr.insert(Events.CONTENT_URI, values)
    }
}
