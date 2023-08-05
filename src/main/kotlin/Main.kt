
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
    val start = "Bucharest"
    val finish = "Arad"

    println(romania.cities[0].toString())
}

fun getPath(map: Cities, start: String, finish: String){
    return findPath(map, start, finish, List<>)
}




data class Connection(val name: String, val cost: Int)
data class City(val name: String, val connections: List<Connection>)
data class Cities(val cities:List<City>)