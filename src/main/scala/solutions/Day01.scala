package com.yalingunayer.aoc2021.solutions

import com.yalingunayer.aoc2021.{RingBuffer, Utils}

object Day01 {
  case class Solution1() extends Solution {
    case class Counter(increased: Int, decreased: Int, last: Option[Int]) {
      def +(current: Int): Counter =
        last match {
          case Some(previous) if current > previous => Counter(increased + 1, decreased, Some(current))
          case Some(previous) if current < previous => Counter(increased, decreased + 1, Some(current))
          case _ => Counter(increased, decreased, Some(current))
        }
    }

    override def solve(): Int =
      Utils.readInput("day01.txt")
        .map(_.toInt)
        .foldLeft(Counter(0, 0, None)) { (counter, current) => counter + current }
        .increased
  }

  case class Solution2() extends Solution {
    case class Counter(increased: Int, decreased: Int, buffer: RingBuffer[Int]) {
      def +(current: Int): Counter =
        if !buffer.isFull then {
          Counter(increased, decreased, buffer + current)
        } else {
          val oldSum = buffer.toSeq.sum
          val newBuffer = buffer + current
          val newSum = newBuffer.toSeq.sum

          if newSum > oldSum then Counter(increased + 1, decreased, newBuffer)
          else if newSum < oldSum then Counter(increased, decreased + 1, newBuffer)
          else Counter(increased, decreased, newBuffer)
        }
    }

    override def solve(): Int =
      Utils.readInput("day01-2.txt")
        .map(_.toInt)
        .foldLeft(Counter(0, 0, RingBuffer.withCapacity(3))) { (counter, current) => counter + current }
        .increased
  }
}
