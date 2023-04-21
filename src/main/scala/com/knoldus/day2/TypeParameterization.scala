package com.knoldus.day2

object TypeParameterization extends App {

  private val listOfInt = new Lists[Int]
  println(listOfInt.createList(List().empty, 4))

  val listOfStrings = new Lists[String]
  println(listOfStrings.createList(List().empty,"Jitendra"))

}

class Lists[A] {
  def createList(list: List[A], value: A): List[A] = {
    list :+ value
  }
}