package tranhph26979.fpoly.customlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView


class UserAdapter(var context: Context, var mangUser:ArrayList<User>):BaseAdapter() {
    class ViewHolder(row:View){
        var tvtenUser:TextView
        var tvtuoiUser:TextView
        var tvgioitinhUser:TextView
    init {
        tvtenUser=row.findViewById(R.id.tv_ten)
        tvtuoiUser=row.findViewById(R.id.tv_tuoi)
        tvgioitinhUser=row.findViewById(R.id.tv_gioitinh)
    }
    }
    override fun getCount(): Int {
       return mangUser.size
    }

    override fun getItem(position: Int): Any {
       return mangUser.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, viewgroup: ViewGroup?): View {
        var view1:View?
        var viewHolder:ViewHolder
        if (view==null){
            var layoutInflater:LayoutInflater=LayoutInflater.from(context)
            view1=layoutInflater.inflate(R.layout.item_list_user,null)
            viewHolder=ViewHolder(view1)
            view1.tag=viewHolder
        }
        else{
            view1=view
            viewHolder=view.tag as ViewHolder
        }
        var user:User=getItem(position) as User
        viewHolder.tvtenUser.text="Tên User: "+user.getTen()
        viewHolder.tvtuoiUser.text="Tuổi User: "+user.getTuoi().toString()
        viewHolder.tvgioitinhUser.text="Giới tính User: "+user.getGioitinh()
        return view1 as View
    }
}