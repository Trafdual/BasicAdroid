package tranhph26979.fpoly.service.BoundService

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import kotlinx.android.synthetic.main.activity_bound.*
import tranhph26979.fpoly.service.R

class BoundActivity : AppCompatActivity() {
    private var boundService:BoundService?=null
    private var isBound=false
    private val connection: ServiceConnection =object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, iBinder: IBinder?) {
            val binder=iBinder as BoundService.CalculatorBinder
            boundService=binder.getService()
            isBound=true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            isBound=false
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bound)
        val intent= Intent(this,BoundService::class.java)
        bindService(intent,connection, Context.BIND_AUTO_CREATE)
        btn_cong.setOnClickListener(){
            var number1=edtnumber1.text.toString().toFloat()
            var number2=edtnumber2.text.toString().toFloat()
            val result=boundService?.summation(number1,number2)
            tv_ketqua.text=result.toString()
        }
        btn_tru.setOnClickListener(){
            var number1=edtnumber1.text.toString().toFloat()
            var number2=edtnumber2.text.toString().toFloat()
            val result=boundService?.subtraction(number1,number2)
            tv_ketqua.text=result.toString()
        }
        btn_nhan.setOnClickListener(){
            var number1=edtnumber1.text.toString().toFloat()
            var number2=edtnumber2.text.toString().toFloat()
            val result=boundService?.multiplication(number1,number2)
            tv_ketqua.text=result.toString()
        }
        btn_chia.setOnClickListener(){
            var number1=edtnumber1.text.toString().toFloat()
            var number2=edtnumber2.text.toString().toFloat()
            val result=boundService?.Division(number1,number2)
            tv_ketqua.text=result.toString()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        unbindService(connection)
    }
}