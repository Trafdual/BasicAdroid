package tranhph26979.fpoly.fragment.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import tranhph26979.fpoly.fragment.fragment.FragmentA
import tranhph26979.fpoly.fragment.fragment.FragmentB
import tranhph26979.fpoly.fragment.R

class Activity1 : AppCompatActivity() {
    private lateinit var fragmentContainerView: FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)
        fragmentContainerView=findViewById(R.id.fragment_containerview)
        val fragmentA= FragmentA()
        supportFragmentManager.beginTransaction().add(fragmentContainerView.id,fragmentA).commit()

    }
    fun replaceFragmentB(){
        val fragmentB= FragmentB()
        supportFragmentManager.beginTransaction().replace(fragmentContainerView.id,fragmentB).commit()
    }
}