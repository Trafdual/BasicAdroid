package tranhph26979.fpoly.customlistview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var users: ArrayList<User>
    private lateinit var adapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        users = ArrayList()
        adapter = UserAdapter(this, users)
        listUser.adapter = adapter
        btnfabUser.setOnClickListener() {
            showaddDialog()
        }
    }

    @SuppressLint("MissingInflatedId")
    private fun showaddDialog() {
        val dialogview = LayoutInflater.from(this).inflate(R.layout.dialog_uer, null)
        val edt_ten: EditText = dialogview.findViewById(R.id.edt_tenUser)
        val edt_tuoi: EditText = dialogview.findViewById(R.id.edt_tuoiUser)
        val edt_giotinh: EditText = dialogview.findViewById(R.id.edt_gioitinhUser)
        val btn_them: Button = dialogview.findViewById(R.id.btn_themUser)
        val btn_cancel: Button = dialogview.findViewById(R.id.btn_cancel)

        val dialogBuilder = AlertDialog.Builder(this).setView(dialogview)
        val alertDialog = dialogBuilder.create()
        alertDialog.show()
        btn_them.setOnClickListener() {
            val ten = edt_ten.text.toString()
            val tuoi = edt_tuoi.text.toString().toIntOrNull() ?: 0
            val gioitinh = edt_giotinh.text.toString()

            val user = User(ten, tuoi, gioitinh)
            users.add(user)
            adapter.notifyDataSetChanged()
            alertDialog.dismiss()
        }
        btn_cancel.setOnClickListener() {
            alertDialog.dismiss()
        }

    }
}