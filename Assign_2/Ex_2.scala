package ASSIGN2.task_1
//Exercise 2: Zip the two lists created in Exercise 1 and then zip the resulting list with its index. A list with three elements per pair is created in the following format: ( x, f(x) , inder). Find the mean value of f(x) and store the respective pair to a variable mean. Refer to Listings 10.11, 10.16 and 10.21 for possible hints
object Ex_2 {

    def main(args: Array[String]): Unit = {

       val list1 : List[Char]= List('a', 'b', 'c')
       val list2 : List[Int] = List(3, 5, 7)

       val vMap = list1.zip(list2)
       val rMap = vMap.zipWithIndex

       //to get f(x) mean from list(x,f(x),index)
       val fx = rMap.map{ case ((_,value),_) => value}
       val mean = fx.sum.toDouble/fx.size
       val r_fx = rMap.map{case ((char,_),index) => ((char,mean),index) }

       println(vMap)
       println(rMap)
       println(r_fx)


     }
}
