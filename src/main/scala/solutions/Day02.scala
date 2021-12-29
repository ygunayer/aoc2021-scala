package com.yalingunayer.aoc2021.solutions

import com.yalingunayer.aoc2021.{Utils, Vector3}

object Day02 {
  type Position = Vector3
  type Movement = Vector3

  def parseDirection(input: String): Vector3 =
    input match {
      case "up" => Vector3.up
      case "down" => Vector3.down
      case "forward" => Vector3.forward
      case _ => throw new IllegalArgumentException(f"Invalid input $input")
    }

  val movementInputPattern = raw"(up|down|forward)\s+(\d+)".r
  def parseMovement(input: String): Movement =
    input match {
      case movementInputPattern(direction, strength) => parseDirection(direction) * strength.toDouble
      case _ => throw new IllegalArgumentException(f"Failed to parse input $input")
    }

  case class Solution1() extends Solution {
    def solveFor(input: LazyList[Movement]): Int =
      val finalPosition = input.foldLeft(Vector3.zero)((v, m) => v + m)
      (finalPosition.z * finalPosition.y).toInt

    override def solve(): Int =
      solveFor(Utils.readInput("day02.txt").map(parseMovement))
  }
}
