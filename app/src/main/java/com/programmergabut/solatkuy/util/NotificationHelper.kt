package com.programmergabut.solatkuy.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.core.app.NotificationCompat
import com.programmergabut.solatkuy.R


class NotificationHelper(c: Context): ContextWrapper(c) {

    private val channel1ID: String = "c_1"
    private val channel1Name: String = "channel1"
    private var mManager: NotificationManager? = null

    init {
        val channel1 = NotificationChannel(channel1ID, channel1Name, NotificationManager.IMPORTANCE_DEFAULT)
        channel1.enableLights(true)
        channel1.enableVibration(true)
        channel1.lightColor = R.color.colorPrimary
        channel1.lockscreenVisibility = Notification.VISIBILITY_PUBLIC

        getManager()?.createNotificationChannel(channel1)
    }

    fun getManager(): NotificationManager? {
        if(mManager == null)
            mManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

        return mManager
    }

    fun getPrayerReminderNC(pID: Int,  pTime: String, pCity: String, pName: String, intent: PendingIntent): NotificationCompat.Builder {

        //val v = this.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        //v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));

        val pattern = longArrayOf(3000, 3000, 3000)
        val message = "now is $pTime in $pCity let's pray $pName"

        val moreTimeIntent = Intent(this, MoreTimeBroadcastReceiver::class.java)
        moreTimeIntent.putExtra("moreTime_prayerID", pID)
        moreTimeIntent.putExtra("moreTime_prayerTime", pTime)
        moreTimeIntent.putExtra("moreTime_prayerCity", pCity)
        moreTimeIntent.putExtra("moreTime_prayerName", pName)

        val actionIntent = PendingIntent.getBroadcast(this, 0, moreTimeIntent,
            PendingIntent.FLAG_UPDATE_CURRENT)

        val lIcon = when(pName){
            getString(R.string.fajr) -> R.drawable.fajr
            getString(R.string.dhuhr) -> R.drawable.dhuhr
            getString(R.string.asr) -> R.drawable.asr
            getString(R.string.maghrib) -> R.drawable.maghrib
            getString(R.string.isha) -> R.drawable.isha
            else -> R.drawable.fajr
        }

        val bitmap = BitmapFactory.decodeResource(resources, lIcon);

        return NotificationCompat.Builder(applicationContext, channel1ID)
            .setContentTitle(pName)
            .setContentText(message)
            .setVibrate(pattern)
            .setColor(getColor(R.color.colorPrimary))
            .setAutoCancel(true)
            .addAction(R.mipmap.ic_launcher, "remind me 10 more minute", actionIntent)
            .setLargeIcon(bitmap)
            .setSmallIcon(R.drawable.ic_notifications_active_24dp)
            .setContentIntent(intent)
            .setPriority(NotificationCompat.DEFAULT_VIBRATE)
    }

}