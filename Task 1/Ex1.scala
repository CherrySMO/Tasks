object Ex1 {

  val arr1 = Array(1, 2, 3, 4, 5) //This classic method goes vice versa for any other data type too, such as String 

  val arr2 = Array.apply(1, 2, 3, 4, 5) // Alternative version

  val arr3 = Array.fill(5)(0) //This will fill 5 times of size in array of value 0

  val arr4 = Array.range(1, 6)
  
  val arr5 = Array.tabulate(5)(i => i * 2) //This will create power of ^2 element at the size of 5

  val arr6 = Array.ofDim[Int](2, 3) //Dim stands for dimensional which in this case create 2d array


  val arr7uno = Array(1, 2)
  val arr7des = Array(3, 4)
  val arr7 = Array.concat(arr7uno, arr7des) //concat stands for concatenation which combines two sets of array

  val arr8 = Array.iterate(1, 5)(_ * 2) // Performs iteration
  
  val arr9 = List(1, 2, 3, 4, 5).toArray //Transfer the list subjects to a set of array
  
  println("arr1: " + arr1.mkString(", "))
  println("arr2: " + arr2.mkString(", "))
  println("arr3: " + arr3.mkString(", "))
  println("arr4: " + arr4.mkString(", "))
  println("arr5: " + arr5.mkString(", "))
  println("arr6: " + arr6.mkString(", "))
  println("arr7: " + arr7.mkString(", "))
  println("arr8: " + arr8.mkString(", "))
  println("arr9: " + arr9.mkString(", "))


}
