package ASSIGN2.task_1

//Exercise 3: Refer to the Listing 11.2,11.3, 11.4,11.5. Find out which other collections support map and flatMap methods and go through their illustrations

//illustration 1: applying flat map to already mapped list, merging two lists into one
object Ex_6_1 {
  def MapOFlists(i: List[Int]): List[List[Int]] = {
    i.map(x =>List(x, x * 2))
  }

  def main(args: Array[String]): Unit = {
   val list = List(1,2,3,4,5,6)
   println(MapOFlists(list).flatMap(identity))
  }
}

//illustration 2: flatmapping a list containing a list that is mapped returning only the mapped list instead of merging
object Ex_6_2 {
  def MapOFlists(i: List[List[Int]]) = {
    i.flatMap(innerlist => innerlist.map(i => i * 2))
  }

  def main(args: Array[String]): Unit = {
    val list = List(List(1,2,3,4,5,6))
    println(MapOFlists(list))
  }
}
//Illustration 3: flatmapping only the even values
object Ex_6_3 {
    def MapOFlists(i: List[List[Int]]) = {
      i.flatMap(innerlist => innerlist.filter(i => i % 2 == 0))
    }

    def main(args: Array[String]): Unit = {
      val list = List(List(1, 2, 3, 4, 5, 6))
      println(MapOFlists(list))
    }
  }