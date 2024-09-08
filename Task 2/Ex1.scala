import scala.util._ // I utilized this wildcard to implement "Random" and "square root" function 

object Ex1{
def isPrime(n: Int): Boolean = {
  if (n <= 1) false
  else if (n == 2) true
  else !(2 to Math.sqrt(n).toInt).exists(n % _ == 0)
}

val randomList = List.fill(15)(Random.nextInt(500) + 50)

val primeIterator = randomList.filter(isPrime).iterator

val ascMap = primeIterator.toList.sorted.zipWithIndex.map { case (prime, index) => (index + 1) -> prime }.toMap

println("Original random list:")
println(randomList.mkString(", "))

println("\nSorted Prime Numbers Mapped:")
ascMap.foreach { case (key, value) => println(s"$key -> $value") }

}
