package com.yalingunayer.aoc2021

import com.yalingunayer.aoc2021.solutions.Solution

import java.util.concurrent.{Executors, ThreadPoolExecutor}
import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

object Aoc2021 {
  def main(args: Array[String]): Unit = {
    implicit val challengeExecutorPool = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(1))

    args.take(2).map(_.toInt) match {
      case Array(day, challenge) =>
        Solution.solve(day, challenge).onComplete {
          case Success(output) =>
            println(f"Solution output: $output")

          case Failure(e) =>
            print(f"Failed to solve due to $e")
            System.exit(1)
        }

      case _ => throw new IllegalArgumentException("Please specify the day and challenge numbers")
    }
  }
}
