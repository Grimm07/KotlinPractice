
import com.google.gson.Gson
import java.io.File
import java.io.FileNotFoundException

fun main(args: Array<String>) {
    val file = File("src/main/resources/romaina_map.json")
    if(!file.exists()){
        println(file.absolutePath)
        throw FileNotFoundException()
    }
    val romania = Gson().fromJson(file.reader(), Cities::class.java)
    println(romania.cities[0].toString())
}


data class Connection(val name: String, val cost: Int)
data class City(val name: String, val connections: List<Connection>)
data class Cities(val cities:List<City>)