package com.yalingunayer.aoc2021

import scala.io.Source

object Utils {
  def readInput(filename: String): LazyList[String] =
    Source.fromResource(filename).getLines()
      .to(LazyList)
      .filter(!_.isBlank)
}
