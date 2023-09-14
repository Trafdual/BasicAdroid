package tranhph26979.fpoly.activity_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var chuoi: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, MainActivity2::class.java)
        btntruyenchuoi.setOnClickListener() {
            chuoi = edtchuoi.text.toString()
            intent.putExtra("data", chuoi)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.e("eee","bắt đầu")
    }

    override fun onResume() {
        super.onResume()
        Log.e("eee","tiếp tục")
    }

    override fun onPause() {
        super.onPause()
        Log.e("eee","tạm dừng")
    }

    override fun onStop() {
        super.onStop()
        Log.e("eee","đã thoát")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("eee","bị hủy")
    }
}