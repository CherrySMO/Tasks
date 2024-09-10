package ASSIGN2.task_1
//Exercise 1: Write an apply function that when called add a complete list that its called upon and prints out its value.
class sumOfList(val list: List[Int]) {
  def sum: Int = list.sum
}

object sumOfList {
  def apply(list: List[Int]): sumOfList = new sumOfList(list)
}

object Ex_7 extends App {
  val sumObj = sumOfList(List(1, 2, 3, 4, 5, 6, 7))
  println(sumObj.sum)
}
