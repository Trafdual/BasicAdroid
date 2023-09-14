package tranhph26979.fpoly.fragment.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_a.view.*
import tranhph26979.fpoly.fragment.R
import tranhph26979.fpoly.fragment.activity.Activity1



class FragmentA : Fragment() {
    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_a, container, false)
        view.button.setOnClickListener {
            (activity as Activity1).replaceFragmentB()
        }

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.e("a","kết nối thành công")
    }

    override fun onStart() {
        super.onStart()
        Log.e("a","bắt đầu")
    }

    override fun onResume() {
        super.onResume()
        Log.e("a","tiếp tục")

    }

    override fun onPause() {
        super.onPause()
        Log.e("a","tạm dừng")
    }

    override fun onStop() {
        super.onStop()
        Log.e("a","dừng lại")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("a","bị hủy")
    }
}
