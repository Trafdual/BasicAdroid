package tranhph26979.fpoly.broadcartreciever

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.widget.Toast

class ExampleBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent?.action)) {
            if (isNeworking(context)) {
                Toast.makeText(context, "Internet conneted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Internet disconnect", Toast.LENGTH_SHORT).show()
            }
        }

    }

    @SuppressLint("WrongConstant", "MissingPermission")
    private fun isNeworking(context: Context?): Boolean {
        val connectivityManager: ConnectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager == null) {
            return false
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network: Network? = connectivityManager.activeNetwork
            if (network == null) {
                return false
            }
            val networkCapabilities: NetworkCapabilities? =
                connectivityManager.getNetworkCapabilities(network)
            return networkCapabilities != null && networkCapabilities.hasCapability(
                NetworkCapabilities.TRANSPORT_WIFI
            )
        } else {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }
    }
}