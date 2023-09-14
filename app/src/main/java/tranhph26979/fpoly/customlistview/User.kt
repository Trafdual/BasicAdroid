package tranhph26979.fpoly.customlistview

class User {
   private var ten :String=""
   private var tuoi:Int=0
   private var gioitinh=""

    constructor(ten: String, tuoi: Int, gioitinh: String) {
        this.ten = ten
        this.tuoi = tuoi
        this.gioitinh = gioitinh
    }
    fun getTen():String{
        return ten
    }
    fun setTen(ten:String){
        this.ten=ten
    } fun getTuoi():Int{
        return tuoi
    }
    fun setTuoi(tuoi:Int){
        this.tuoi=tuoi
    }
    fun getGioitinh():String{
        return gioitinh
    }
    fun setGioitinh(gioitinh:String){
        this.gioitinh=gioitinh
    }


}