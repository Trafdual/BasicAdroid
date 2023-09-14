package tranhph26979.fpoly.fragment.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tranhph26979.fpoly.fragment.R


class FragmentB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("b","kết nối thành công")
    }

    override fun onStart() {
        super.onStart()
        Log.e("b","bắt đầu")
    }

    override fun onResume() {
        super.onResume()
        Log.e("b","tiếp tục")

    }

    override fun onPause() {
        super.onPause()
        Log.e("b","tạm dừng")
    }

    override fun onStop() {
        super.onStop()
        Log.e("b","dừng lại")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("b","bị hủy")
    }
}