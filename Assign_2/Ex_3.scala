package ASSIGN2.task_1
//Exercise 3: Write a Scala code that takes in a vector as an integer list and calculates its Eu- clidean norm. Recall that this is also termed as the magnitude of a vector and is evaluated as given below.
object Ex_3 {

  //here the norm defines the nth value
  def euclidean_vector(vec: Vector[Int], norm: Int): Double = {
    val dval = math.sqrt(vec.map(x => x * x).sum)
    def increament(i: Int, d : Double): Double = {
      if (i == norm) {
       d
      }
      else increament(i+1,d+dval)
    }
    increament(0,0.0)
  }

  def main(args: Array[String]): Unit = {
    println(euclidean_vector(Vector(1, 2, 3, 4, 5, 6),9))
  }
}