def elementwiseSum(arr1: Array[Double], arr2: Array[Double]): Array[Double] = {
  (arr1, arr2).zipped.map(_ + _)
}

val arr1 = Array(3.5, 2.4, 9.7 )
val arr2 = Array(2.20, 3.0, 3.55)

val result = elementwiseSum(arr1, arr2)
println(result.mkString(", "))  // Output: 5.0, 7.0, 9.0
