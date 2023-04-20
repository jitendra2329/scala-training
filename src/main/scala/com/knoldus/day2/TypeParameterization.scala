package com.knoldus.day2

import scala.jdk.Accumulator

object TypeParameterization extends App {

  val listOfInt = new Lists[Int]
  println(listOfInt.createList(List().empty, 4))

  val listOfStrings = new Lists[String]
  println(listOfStrings.createList(List().empty, "Jitendra"))

}

class Lists[A] {
  def createList(list: List[A], value: A): List[A] = {
    list :+ value
  }
}