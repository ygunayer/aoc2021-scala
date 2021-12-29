package com.yalingunayer.aoc2021

import com.yalingunayer.aoc2021.solutions.Day02.{Solution1, Movement}
import org.scalatest.*
import flatspec.*
import matchers.*

class Day02Test extends AnyFlatSpec with should.Matchers {
  "Solution1.solveFor" should "find correct result for example input" in {
    val input: LazyList[Movement] = LazyList(
      Vector3.forward * 5,
      Vector3.down * 5,
      Vector3.forward * 8,
      Vector3.up * 3,
      Vector3.down * 8,
      Vector3.forward * 2
    )

    Solution1().solveFor(input) should be (150)
  }
}
