package ASSIGN2.task_1
//Exercise 1: Write Scala program that implements the function y = a * x ^ 2 + bx + c , where a = 3 , b = 5 and c = 7 (this is similar to what has been done in Listing 10.4). Create a list of integers in the range - 3 <= x <= 3 and use the defined function to map its elements to another list. Print the mapped list and verify the results. (Try to use wildcard wherever possible.)
import scala.util.Random

object Ex_1 {
  def main(args: Array[String]): Unit = {
    val umap = Map('a' -> 3, 'b' -> 5, 'c' -> 7)
    def random(): Int = Random.between(-3, 4)
    val Xvariable = Map('x' -> random())
    val x = Xvariable.get('x')

    val valueOfA = umap.get('a')
    val valueOfB = umap.get('b')
    val valueOfC = umap.get('c')

    def f(i: Option[Int]): Option[(Int, Int)] = i.map(x => (x, x * x))
    val result = f(x)

    def a(k: Option[Int], result: Option[(Int, Int)]): Option[Int] = for {
      a <- k
      (_, xSquared) <- result
    } yield a * xSquared

    def b(k: Option[Int], v: Option[Int]): Option[Int] = for {
      b <- k
      x <- v
    } yield b * x

    val ax2 = a(valueOfA, result)
    val bx = b(valueOfB, x)

    def sumOFroots(a: Option[Int], b: Option[Int], c: Option[Int]): Option[Int] = for {
      valA <- a
      valB <- b
      valC <- c
    } yield valA + valB + valC

    def greaterThanZero(a: Option[Int]): Option[Boolean] = a.map(_ > 0)

    def lessThanZero(a: Option[Int]): Option[Boolean] = a.map(_ < 0)

    def Zero(a: Option[Int]): Option[Boolean] = a.map(_ == 0)

    def GTZBoolean(opt: Option[Boolean]): String = opt match {
      case Some(true)  => "roots are real and different"
      case Some(false) => "roots are imaginary."
      case None        => "No value"
    }

    def display(): Unit = {
      val rootValue = sumOFroots(ax2, bx, valueOfC)
      println(s"ax^2 = ${ax2.last}, bx = ${bx.last}, c = ${valueOfC.last} value of x = ${x.last} total = ${rootValue.last}")
      val GTZ = greaterThanZero(rootValue)
      println(GTZBoolean(GTZ))
      val list : List[Option[Int]] = List(ax2,bx,valueOfC,x,rootValue)
      val filteredList: List[Int] = list.flatMap {
        case Some(value) => Some(value)
        case None => None
      }
      println(s"List of all values: $filteredList")
    }

    display()
  }
}
