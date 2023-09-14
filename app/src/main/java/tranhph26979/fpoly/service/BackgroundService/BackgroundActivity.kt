package tranhph26979.fpoly.service.BackgroundService

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import tranhph26979.fpoly.service.R

class BackgroundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_background)
        val intent= Intent(this,BackgroundService::class.java)
        startService(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("note","ứng dụng đã tắt")
    }
}