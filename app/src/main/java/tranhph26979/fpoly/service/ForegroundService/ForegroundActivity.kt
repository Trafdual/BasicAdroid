package tranhph26979.fpoly.service.ForegroundService

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_foreground.*
import tranhph26979.fpoly.service.R

class ForegroundActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foreground)
        btn_startservice.setOnClickListener(){
            clickStartService()
        }
        btn_stopservice.setOnClickListener(){
            clickStopService()
        }

    }

    private fun clickStopService() {
        val intent: Intent = Intent(this,services::class.java)
        stopService(intent)
    }

    private fun clickStartService() {
        val song=Song("Hẹn Kiếp Sau","Khả Hiệp",R.drawable.hks,R.raw.n1)
        val intent: Intent = Intent(this,services::class.java)
        val bundle:Bundle=Bundle()
        bundle.putSerializable("object_song",song)
        intent.putExtras(bundle)
        startService(intent)
    }
}