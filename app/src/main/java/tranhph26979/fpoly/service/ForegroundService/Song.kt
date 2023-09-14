package tranhph26979.fpoly.service.ForegroundService
import java.io.Serializable

class Song : Serializable {
    private var tilte:String=""
    private var single:String=""
    private var image:Int=0
    private var resource:Int=0

    constructor(tilte: String, single: String, image: Int, resource: Int) {
        this.tilte = tilte
        this.single = single
        this.image = image
        this.resource = resource
    }
    fun getTitle():String{
        return tilte
    }
    fun setTitle(tilte: String){
        this.tilte=tilte
    }
    fun getSingle():String{
        return single
    }
    fun setSingle(single: String){
        this.single=single
    }
    fun getImage():Int{
        return image
    }
    fun setImage(image: Int){
        this.image=image
    }
    fun getResource():Int{
        return resource
    }
    fun setResource(resource: Int){
        this.resource=resource
    }
}