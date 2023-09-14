package tranhph26979.fpoly.service.BoundService

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class BoundService: Service() {
    private val binder=CalculatorBinder()
    inner class CalculatorBinder:Binder(){
        fun getService():BoundService=this@BoundService
    }

    fun summation(number1:Float,number2: Float):Float{
        return number1+number2
    }
    fun subtraction(number1:Float,number2: Float):Float{
        return number1-number2
    }
    fun multiplication(number1:Float,number2: Float):Float{
        return number1*number2
    }
    fun Division(number1:Float,number2: Float):Float{
        return number1/number2
    }
    override fun onBind(intent: Intent?): IBinder {
        return binder
    }
}