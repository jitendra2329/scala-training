package com.knoldus.day1

object PartialFunctions extends App{
  private val aPartialFunction: PartialFunction[Int, Int] = {
    case 1 => 21
    case 2 => 22
    case 5 => 55
  }

  println(aPartialFunction.isDefinedAt(6))

  println(aPartialFunction(2))

  private val liftedPartialFunction = aPartialFunction.lift

  println(liftedPartialFunction(2))
  println(liftedPartialFunction(3))

  private val partialFunctionChain = aPartialFunction.orElse[Int, Int] {
    case 9 => 99
  }

  println(partialFunctionChain(1))
  println(partialFunctionChain(9))




}
