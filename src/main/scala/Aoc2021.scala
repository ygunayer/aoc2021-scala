package com.yalingunayer.aoc2021

import challenges.*

import java.util.concurrent.{Executors, ThreadPoolExecutor}
import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}

object Aoc2021 {
  def main(args: Array[String]): Unit = {
    implicit val challengeExecutorPool = ExecutionContext.fromExecutor(Executors.newFixedThreadPool(1))

    val result = for {
      day <- args.headOption.map(_.toInt)
      solution <- solveForDay(day)
    } yield solution

    result match {
      case Some(future) =>
        future onComplete {
          case Success(output) =>
            println(f"Solution output: $output")

          case Failure(e) =>
            print(f"Failed to solve due to $e")
            System.exit(1)
        }

      case _ => println("No solution found")
    }
  }
}
