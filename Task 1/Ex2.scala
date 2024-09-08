object Ex2{
  var S1: Set[Int] = Set(1, 3, 2, 4, 5)

  def result() : Unit = {
    S1 = s1.map(x => x * x)
  }

  def main(args: Array[String]): Unit = {
    println(S1) 
    result()
    println(S1) 
  }
}
