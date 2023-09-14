package tranhph26979.fpoly.service.ForegroundService
import android.annotation.SuppressLint
import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.MediaPlayer
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import tranhph26979.fpoly.service.R

class services : Service() {
    private  var mediaPlayer: MediaPlayer? =null
    private val ACTION_PAUSE: Int = 1
    private val ACTION_RESUME: Int = 2
    private val ACTION_CLEAR: Int = 3
    private var isPlaying: Boolean = false
    private lateinit var  mSong:Song

    @SuppressLint("SuspiciousIndentation")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        val strDataIntent: String? = intent?.getStringExtra("key")
        val bundle: Bundle? = intent!!.extras
        if (bundle != null) {
            val song: Song? = bundle.get("object_song") as? Song
            if (song!=null){
                mSong=song
                startMusic(song)
                sendNotification(song)
            }
            else{
                Log.e("err","song null")
            }

        }
        val actionmusic:Int=intent.getIntExtra("action_music_service",0)
        handleActionMusic(actionmusic)

        return START_NOT_STICKY
    }

    private fun startMusic(song: Song) {
        if (mediaPlayer==null){
            mediaPlayer = MediaPlayer.create(applicationContext, song.getResource())
        }

        mediaPlayer!!.start()
        isPlaying = true
    }

    private fun handleActionMusic(action: Int) {
        when (action) {
            ACTION_PAUSE -> {
                pauseMusic()
            }
            ACTION_RESUME -> {
                resumeMusic()
            }
            ACTION_CLEAR -> {
                stopSelf()
            }
        }
    }

    private fun pauseMusic() {
        if (mediaPlayer != null && isPlaying) {
            mediaPlayer!!.pause()
            isPlaying = false
            sendNotification(mSong)
        }
    }

    private fun resumeMusic() {
        if (mediaPlayer != null && !isPlaying) {
            mediaPlayer!!.start()
            isPlaying = true
            sendNotification(mSong)
        }
    }


    @SuppressLint("SuspiciousIndentation")
    private fun sendNotification(song: Song?) {
        val intent = Intent(this, ForegroundActivity::class.java)
        val pendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        val bitmap: Bitmap = BitmapFactory.decodeResource(resources, song!!.getImage())
        val remoteViews = RemoteViews(packageName, R.layout.laout_custom_notifi)
        remoteViews.setTextViewText(R.id.tv_title_song, song.getTitle())
        remoteViews.setTextViewText(R.id.tv_single_song, song.getSingle())
        remoteViews.setImageViewBitmap(R.id.img_song, bitmap)
        remoteViews.setImageViewResource(
            R.id.img_play_or_pause,
            R.drawable.ic_baseline_pause_circle_24
        )
        if (isPlaying) {
            remoteViews.setOnClickPendingIntent(
                R.id.img_play_or_pause,
                getPendingIntent(this@services, ACTION_PAUSE)
            )
            remoteViews.setImageViewResource(
                R.id.img_play_or_pause,
                R.drawable.ic_baseline_pause_circle_24
            )
        } else {
            remoteViews.setOnClickPendingIntent(
                R.id.img_play_or_pause,
                getPendingIntent(this@services, ACTION_RESUME)
            )
            remoteViews.setImageViewResource(
                R.id.img_play_or_pause,
                R.drawable.ic_baseline_play_circle_24
            )
        }
        remoteViews.setOnClickPendingIntent(R.id.img_clear, getPendingIntent(this@services, ACTION_CLEAR))


        val notification = NotificationCompat.Builder(this, (applicationContext as MyApplication).CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_music_note_24)
            .setContentIntent(pendingIntent).setCustomContentView(remoteViews)
            .setSound(null)
            .build()

        startForeground(1, notification)
    }

    private fun getPendingIntent(context: Context, action: Int): PendingIntent {
        val intent = Intent(this, MyReciever::class.java)
        intent.putExtra("action_music", action)
        return PendingIntent.getBroadcast(
            context.applicationContext,
            action,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("hello", "Myservice oncreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("hello", "Myservice ondestroy")
        if (mediaPlayer!=null){
            mediaPlayer?.release()
            mediaPlayer=null
        }

    }
}