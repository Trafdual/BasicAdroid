package tranhph26979.fpoly.fragment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import tranhph26979.fpoly.fragment.activity.Activity1
import tranhph26979.fpoly.fragment.activity.Activity2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bai1.setOnClickListener(){
            startActivity(Intent(this,Activity1::class.java))
        }
        bai2.setOnClickListener(){
            startActivity(Intent(this,Activity2::class.java))
        }
    }
}