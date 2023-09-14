package tranhph26979.fpoly.fragment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_2.*
import tranhph26979.fpoly.fragment.R
import tranhph26979.fpoly.fragment.fragment.FragmentC
import tranhph26979.fpoly.fragment.fragment.FragmentD

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val fragmentC= FragmentC()
        val fragmentD= FragmentD()
        supportFragmentManager.beginTransaction()
            .add(fragment_containerviewc.id,fragmentC)
            .add(fragment_containerviewd.id,fragmentD)
            .commit()
    }
}