package com.knoldus.day1

object CurriedFunction extends App {

  private def curriedFunction(f: Int => Int): Int => Int = {
    (value: Int ) => f(value)
  }

  private val increment = curriedFunction((value: Int ) => value + 1 )
  println(increment(10))

  // other way to do above(called curried functions)
  val result = curriedFunction((value: Int ) => value + 1 )(10)
  println(result)

}
