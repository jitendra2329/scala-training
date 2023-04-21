package com.knoldus.day2

trait Distance {
  def distanceBetweenPoints(p1: Point, p2: Point): Double
}

object Implicits extends App {

  private val firstPoint = Point(0, 2)
  private val secondPoint = Point(4, 5)

  implicit object Distance extends Distance {
    def distanceBetweenPoints(firstPoint: Point, secondPoint: Point): Double = {
      math.sqrt(math.pow(firstPoint.xAxis - secondPoint.xAxis, 2) + math.pow(firstPoint.yAxis - secondPoint.yAxis, 2))
    }

  }

  private def findDistance(p1: Point, p2: Point)(implicit distance: Distance): Double = {
    distance.distanceBetweenPoints(p1, p2)
  }

  println("Distance between the points: " + findDistance(firstPoint, secondPoint))
}

case class Point(xAxis: Double, yAxis: Double)
