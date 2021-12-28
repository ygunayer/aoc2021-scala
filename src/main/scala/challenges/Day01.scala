package com.yalingunayer.aoc2021.challenges

import com.yalingunayer.aoc2021.Utils

object Day01 extends Challenge(1) {
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
      .foldLeft(Counter(0, 0, None)) { (counter, current) => counter + current }
      .increased
}
