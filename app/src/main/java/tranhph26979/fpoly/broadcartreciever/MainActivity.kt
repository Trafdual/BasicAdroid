package tranhph26979.fpoly.broadcartreciever

import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var exampleBroadcastReceiver: ExampleBroadcastReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        exampleBroadcastReceiver= ExampleBroadcastReceiver()
    }

    override fun onStart() {
        super.onStart()
        val intentFilter: IntentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(exampleBroadcastReceiver,intentFilter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(exampleBroadcastReceiver)
    }
}