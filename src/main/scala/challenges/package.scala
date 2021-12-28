package com.yalingunayer.aoc2021

import scala.concurrent.{ExecutionContext, Future}

package object challenges {

  case class Challenge(day: Int) {
    def solve(): Int = throw new NotImplementedError("Unspecified challenge implementation")
  }

  def challengeForDay(day: Int): Option[Challenge] = {
    day match {
      case 1 => Some(Day01)
      case 2 => Some(Day02)
      case _ => None
    }
  }

  def solveForDay(day: Int)(implicit ec: ExecutionContext): Option[Future[Int]] =
    for {
      challenge <- challengeForDay(day)
    } yield Future { challenge.solve() }
}
