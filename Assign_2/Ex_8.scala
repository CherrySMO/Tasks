package ASSIGN2.task_1
//Exercise 2: Write a function which has two inputs of any type and then implicitly converts these input of any type to string and print the addition of these strings.
object Ex_8 {
implicit def Concat(x: Int): String = x.toString

def printConcat(str1: String, str2: String): Unit = {
  println(str1+str2)
}
def main(args: Array[String]): Unit = {
  val x = 600
  val y = 900

  printConcat(x,y)
}
}
