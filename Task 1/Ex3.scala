object Ex3{
def userProfile(id: Int, name: String, email: Option[String]): String = {
  email match {
    case Some(credentials) => "User is created: ID=$id, Name=$name, Email=$e"
    case None => "User created: ID=$id, Name=$name, Email not provided"
  }
}

println(userProfile(1, "Mudassir Mairaj", Some("mudassirghulamsarwar51@gmail.com")))
println(userProfile(2, "Uzair", None))

}
