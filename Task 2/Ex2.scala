object Ex2{
  def charArray(start: Int, accumalation: List[Char] = List()): List[Char] = {
  if (start > 122) accumalation // 98 is the ASCII code for "z" 
  else charArray(start + 1, accumalation :+ start.toChar) 
}
val result = charArray(98) // 98 is the ASCII code for "a"
println(result)

}
