package com.knoldus.day1

//object HigherOrderFunctions {
//  def apply = new HigherOrderFunctions
//
//}
object HigherOrderFunctions extends App {

  private val higherOrderFunctions = new HigherOrderFunctions

  val sum: List[Int] => Double = (list: List[Int]) => list.sum
  val list: List[Int] = List(3, 6, 4, 9)

  // average is a higher order function which takes a function
  val result: Double = higherOrderFunctions.average(sum, list)
  println(result)


  // use of map on list
  private val newListUsingMap = higherOrderFunctions.useOfMap(list)
  println(newListUsingMap)


  // use of flatMap
  private val listOfLists = List(List(3, 5, 4, 6), List(4, 9), List(8, 39))
  private val newListUsingFlatMap = higherOrderFunctions.useOfFlatMap(listOfLists)
  println(newListUsingFlatMap)

  // use of filter
  private val newListUsingFilter = higherOrderFunctions.useOfFilter(newListUsingFlatMap)
  println(newListUsingFilter)

  // use of foldLeft
  private val listOfStrings = List("Jitendra", "Rajan", "Pawan", "Manish")
  private val newListOfStrings = higherOrderFunctions.useOfFoldLeft(listOfStrings, 'n')
  println(newListOfStrings)

  // use of reduce
  private val maxValueOfList = higherOrderFunctions.useOfReduce(newListUsingFlatMap)
  println(maxValueOfList)
}

class HigherOrderFunctions {

  // it is an higher order function which takes a function (List[Int] => Int )  and a list[Int]
  // and then return the average of the list
  private def average(function: List[Int] => Double, list: List[Int]): Double = {
    val result = function(list) / list.length
    result
  }

  // it will multiply each element of the list by 2 and return the new list
  private def useOfMap(list: List[Int]): List[Int] = {
    list.map(value => value * 2)
  }

  // it will first extract the list[Int] from the given list and then
  // multiply each element of the list by 3 and return a new list
  private def useOfFlatMap(list: List[List[Int]]): List[Int] = {
    list.flatMap { values =>
      values.map(_ * 3)
    }

//    list.map { values =>
//      values.map(_ * 3)
//    }.flatten
  }

  // it will filter even values
  private def useOfFilter(list: List[Int]): List[Int] = {
    list.filter(_ % 2 == 0)
  }

  // It will capitalize the given letter in the Strings of list
  private def useOfFoldLeft(list: List[String], characterToCapitalize: Char): List[String] = {
    list.map(_.foldLeft("")((string, character) =>
      if (character == characterToCapitalize) string + character.toString.toUpperCase()
      else string + character
    ))
  }

  // It will find the greatest element in the given list
  private def useOfReduce(list: List[Int]): Int = {
    list.reduce((firstValue, secondValue) =>
      if (firstValue < secondValue) secondValue
      else firstValue)
  }
}