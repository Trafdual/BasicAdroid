package tranhph26979.fpoly.service.ForegroundService
import android.annotation.SuppressLint
import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class MyApplication : Application() {
    val CHANNEL_ID:String="channel_service_example"
    override fun onCreate() {
        super.onCreate()
        creatChannelNotification()
    }

    @SuppressLint("SuspiciousIndentation")
    private fun creatChannelNotification() {
        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            val channel:NotificationChannel= NotificationChannel(CHANNEL_ID,"channel",NotificationManager.IMPORTANCE_DEFAULT)
            channel.setSound(null,null)
            val manager:NotificationManager=getSystemService(NotificationManager::class.java)
            if (manager!=null){
                manager.createNotificationChannel(channel)
            }
        }
    }
}