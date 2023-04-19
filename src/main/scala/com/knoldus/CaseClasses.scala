package com.knoldus


object CaseClasses extends App {
  private val firstUser = User("knol01", "Jitendra", 24)
  private val secondUser = User("knol02", "Ajit", 24)
  private val thirdUser = User("knol03", "Manish", 23)

  // printing the attributes of the Users
  println(firstUser)
  println(secondUser)
  println(thirdUser)

  // comparing the instances of the User
  private val fourthUser = User("knol01", "Jitendra", 24)
  println(fourthUser.equals(firstUser))
  println(secondUser.equals(firstUser))

  // use of copy method
  private val fifthUser = firstUser.copy(userId = "knol05", name = "Akhil")
  println(fifthUser)

  // pattern matching with case classes
  private val listOfUsers = List(firstUser, secondUser, thirdUser, fourthUser, fifthUser)

  private def matchingUsers(listOfUser: List[User]): List[String] = {
    listOfUser.map {
      case User("knol01", _, _) => "Jitendra"
      case User("knol02", _, _) => "Ajit"
      case User("knol03", _, _) => "Manish"
      case User(_, name, _) => s"$name"
    }
  }
  println(matchingUsers(listOfUsers))
}

// creating a data structure of Users
case class User(userId: String, name: String, age: Int)