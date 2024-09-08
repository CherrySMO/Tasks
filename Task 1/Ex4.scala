object Ex4{ 
val numbers = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

val squared = numbers.map(x => x * x)
println("Squared numbers: " + squared.mkString(", "))

val evenNumbers = numbers.filter(x => x % 2 == 0)
println("Even numbers: " + evenNumbers.mkString(", "))

val sum = numbers.reduce((x, y) => x + y)
println("Sum of all numbers: " + sum)

val sumPlusOne = numbers.fold(1)((acc, x) => acc + x)
println("Sum of all numbers plus 1: " + sumPlusOne)


print("Printing each number: ")
numbers.foreach(x => print(x + " "))
println()

val pairs = numbers.flatMap(x => Array(x, x))
println("Pairs: " + pairs.mkString(", "))

val oddEvenGroups = numbers.groupBy(x => if (x % 2 == 0) "even" else "odd")
println("Odd-Even groups: " + oddEvenGroups)

val multipliedEvens = numbers.collect { case x if x % 2 == 0 => x * 10 }
println("Evens multiplied by 10: " + multipliedEvens.mkString(", "))

val descendingOrder = numbers.sortWith((x, y) => x > y)
println("Descending order: " + descendingOrder.mkString(", "))

val hasEven = numbers.exists(x => x % 2 == 0)
println("Has even number: " + hasEven)

val allPositive = numbers.forall(x => x > 0)
println("All numbers are positive: " + allPositive)

val (evens, odds) = numbers.partition(x => x % 2 == 0)
println("Evens: " + evens.mkString(", ") + ", Odds: " + odds.mkString(", "))

}
