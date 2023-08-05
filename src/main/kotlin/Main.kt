
import com.google.gson.Gson
import java.io.File
import java.io.FileNotFoundException
import java.util.PriorityQueue
import kotlin.math.max

fun main(args: Array<String>) {
    val file = File("src/main/resources/romaina_map.json")
    if(!file.exists()){
        println(file.absolutePath)
        throw FileNotFoundException()
    }
    var p = PriorityQueue<Int>{ p1, p2->
        max(p1, p2)

    }
    p.add(30)
    p.add(20)
    p.add(10)
    p.add(100)
    p.add(110)
    p.add(1000)
    println("QUEUE: $p")
    p.poll()
    println("QUEUE SORTED: $p")
    val romania = Gson().fromJson(file.reader(), Cities::class.java)
//    println(romania.cities[0].toString())
    search(romania, "Bucharest", "Arad")

}

fun search(map: Cities, start: String, finish: String){
    return findPath(map, start, finish, listOf())
}

fun findPath(map: Cities, start: String, finish: String, visited: List<String> ){
    for(i in map.cities){
        if(!visited.contains(i.name)){

        }
    }
}


data class Connection(val name: String, val cost: Int)
data class City(val name: String, val connections: List<Connection>)
data class Cities(val cities:List<City>)