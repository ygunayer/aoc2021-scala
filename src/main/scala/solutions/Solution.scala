package com.yalingunayer.aoc2021.solutions

import scala.concurrent.{ExecutionContext, Future}

trait Solution {
  def solve(): Int
}

object Solution {
  type ChallengeKey = (Int, Int)

  val solutions: Map[ChallengeKey, Solution] = Map(
    (1, 1) -> Day01.Solution1(),
    (1, 2) -> Day01.Solution1(),
    (2, 1) -> Day02.Solution1()
  )

  def solve(day: Int, challenge: Int)(implicit ec: ExecutionContext): Future[Int] =
    solutions.get((day, challenge)) match {
      case Some(solution) => Future { solution.solve() }
      case _ => Future.failed(new NotImplementedError(f"Unknown challenge $challenge for day $day"))
    }
}
