import scala.util._

object Ex5{
  
def buildMap[A, B](data: Seq[A], f: A => B): Map[A, B] = {
  data.map(x => x -> f(x)).toMap  
}

// Example usage
val list = Array(1, 2, 3, 4, 5)
def func(x: Int): Boolean = x % 2 == 0  

val result = buildMap(list, func)
println(result) 

}
