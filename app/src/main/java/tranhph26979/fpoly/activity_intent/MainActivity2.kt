package tranhph26979.fpoly.activity_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val intent = intent
        val chuoi: String = intent.getStringExtra("data")!!
        tvchuoi.text = chuoi
    }
    override fun onStart() {
        super.onStart()
        Log.e("ee","bắt đầu")
    }

    override fun onResume() {
        super.onResume()
        Log.e("ee","tiếp tục")
    }

    override fun onPause() {
        super.onPause()
        Log.e("ee","tạm dừng")
    }

    override fun onStop() {
        super.onStop()
        Log.e("ee","đã thoát")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ee","bị hủy")
    }
}