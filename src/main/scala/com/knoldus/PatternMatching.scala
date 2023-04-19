package com.knoldus


import scala.util.{Random, Try, Success, Failure}


object PatternMatching extends App {

  // pattern matching on constants
  private val choice = Random.nextInt(10)
  choice match {
    case 1 => println("This is number 1")
    case 2 => println("This is number 2")
    case 3 => println("This is number 3")
    case 4 => println("This is number 4")
    case _ => println("No any number matched.")
  }

  // pattern matching on variables
  private val result = Try(20 / Random.nextInt(3))
  result match {
    case Success(value) => println(value)
    case Failure(exception) => println(exception.getMessage)
  }

  // pattern matching with case classes
  case class Animal(name: String, breed: String)

  private val dog = Animal("Dog", "Kanni")

  dog match {
    case Animal(_, "Kanni") => println("The breed of the dog is \"Kanni\"")
    case Animal(_, _) => println("No breed found.")
  }

  // pattern matching with Tuples
  private val tuple = Tuple2("Jitendra", 1882)

  tuple match {
    case ("Jitendra", id) => println(s"Jitendra's id is $id")
    case (name, id) => println(name + " : " + id)
  }

  // pattern matching with List
  private val list = List(4, 7, 2, 9, 1)

  private def sum(list: List[Int]): Int = {
    list match {
      case Nil => throw new IllegalArgumentException("List is empty")
      case head :: Nil => head
      case head :: tail => head + sum(tail)
    }
  }

  println("sum of the element of the list = " + sum(list))

  // pattern matching with Option type

  private val nameOfEmployee: Option[String] = Some("Jitendra")

  nameOfEmployee match {
    case Some(value) => println(s"Name of the employee : $value")
    case None => println("No employee found.")
  }


  // patten matching with classes
  private val person = new Person("Jees")

  person match {
    case Person(name) => println(s"Person name is : $name")
  }
}

// defining a class Person
class Person(val name: String)

// making companion object of Person class
object Person {

  // defining unapply method for making person class ready of patten matching
  def unapply(person: Person): Option[String] = {
    Some(person.name)
  }
}