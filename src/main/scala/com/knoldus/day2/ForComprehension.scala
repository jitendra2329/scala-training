package com.knoldus.day2

import scala.util.Try

object ForComprehension extends App {
  val firstValue = Try(20.0 / 3)
  val secondValue = Try(30.0 / 9)
  private val thirdValue = Try(40.0 / 4)

  private def usingFlatMapAndMap(firstValue:Try[Double], secondValue: Try[Double], thirdValue: Try[Double] ): Try[Double] = {
    val sumResult = firstValue.flatMap { value1 =>
      secondValue.flatMap { value2 =>
        thirdValue.map(value3 =>
          value1 + value2 + value3
        )
      }
    }
    sumResult
  }


  // using for comprehension
  private def forComprehension(firstValue:Try[Double], secondValue: Try[Double], thirdValue: Try[Double] ): Try[Double] = {
    for{
      value1 <- firstValue
      value2 <- secondValue
      value3 <- thirdValue
    } yield  value1 + value2 + value3
  }
  println(usingFlatMapAndMap(firstValue, secondValue, thirdValue))
  println(forComprehension(firstValue, secondValue, thirdValue))


}
