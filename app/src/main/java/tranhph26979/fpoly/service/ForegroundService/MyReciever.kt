package tranhph26979.fpoly.service.ForegroundService
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyReciever: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val actionmusic= intent?.getIntExtra("action_music",0)
        if (context != null && actionmusic != null) {
            val serviceIntent = Intent(context, services::class.java)
            serviceIntent.putExtra("action_music_service", actionmusic)
            context.startService(serviceIntent)
        }
    }
}