package com.knoldus.day2

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

object Futures extends App {

  private val aFuture: Future[String] = Future {
    Thread.sleep(2000)
    "I am from Future"
  }

  println("waiting for future value!")
  aFuture.onComplete {
    case Success(value) => println(value)
    case Failure(exception) => println(exception)
  }

  private val sumOfFuture: Future[Double] = Future {
    (1 to 1000000000).sum
  }

  sumOfFuture.onComplete {
    case Success(result) => println(result)
    case Failure(exception) => println(exception)
  }

  // --------------------------------------------------------------------------
  private def fetchUser(id: Int): Future[FbProfile] = Future {
    if (id == 1) FbProfile(id, "Jitendra")
    else throw new RuntimeException("user not defined associated with this id.")
  }

  val id = 2
  private val user = fetchUser(id)

  private val futureRecoverUser = user.recover {
    case exception => FbProfile(id, "unknown user")
  }

  private val futureRecoverWith = user.recoverWith {
    case exception => Future.successful(FbProfile(id, "unknown user"))
  }

  futureRecoverWith.onComplete {
    case Success(value) => println("P " + value)
    case Failure(exception) => println(exception.getMessage)
  }

  futureRecoverUser.onComplete {
    case Success(value) => println(s"user id: ${value.id}, user name: ${value.name}")
    //    case Success(value) => println(value)
    case Failure(exception) => print(exception.getMessage)
  }

  Thread.sleep(2000)
}

case class FbProfile(id: Int, name: String)
