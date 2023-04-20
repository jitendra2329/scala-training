package com.knoldus.day2

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.language.implicitConversions
import scala.util.{Success, Failure}

object ImplicitOrdering extends App {

  private val person1 = Person("Jitendra", 24)
  private val person2 = Person("Manish", 25)
  private val person3 = Person("Ajit", 22)
  private val person4 = Person("Jees", 21)
  private val person5 = Person("Raju", 26)
  val list = List(person1, person2, person3, person4, person5)

  println(list)

  private val sortedList = list.sorted
  println(sortedList)

  private val triangle = new Triangle
  implicit val PI: Double = 3.14

  private val area = triangle.areaOfTriangle(3.0)
  area.onComplete {
    case Success(value) => println(value)
    case Failure(exception) => println(exception.getMessage)

  }

  private val circumference = triangle.circumferenceOfTriangle(5.0)
  circumference.onComplete{
    case Success(value) => println(value)
    case Failure(exception) => println(exception.getMessage)

  }
//  println(circumference)

  Thread.sleep(2000)
}

case class Person(name: String, age: Int) extends Ordered[Person] {
  implicit def compare(person: Person): Int = {
    if (age < person.age) -1
    else if (age == person.age) 0
    else 1
  }
}

class Triangle {

  def areaOfTriangle(radius: Double)(implicit PI: Double): Future[Double] = Future {
    PI * radius * radius
  }

  def circumferenceOfTriangle(radius: Double)(implicit PI: Double): Future[Double] = Future {
    2 * PI * radius
  }
}