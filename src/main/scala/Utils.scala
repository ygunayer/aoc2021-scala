package com.yalingunayer.aoc2021

import scala.io.Source

object Utils {
  def readInput(filename: String): LazyList[Int] =
    Source.fromResource(filename).getLines()
      .to(LazyList)
      .filter(!_.isBlank)
      .map(_.toInt)
}
