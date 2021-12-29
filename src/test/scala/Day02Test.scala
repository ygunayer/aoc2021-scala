package com.yalingunayer.aoc2021

import com.yalingunayer.aoc2021.solutions.Day02._
import org.scalatest.*
import flatspec.*
import matchers.*

class Day02Test extends AnyFlatSpec with should.Matchers {
  val input: LazyList[Movement] = LazyList(
    Vector3.forward * 5,
    Vector3.down * 5,
    Vector3.forward * 8,
    Vector3.up * 3,
    Vector3.down * 8,
    Vector3.forward * 2
  )

  "Solution1.solveFor" should "find correct result for example input" in {
    Solution1().solveFor(input) should be (150)
  }

  "Solution2.AimedPosition" should "move forward properly" in {
    val initialPosition = AimedPosition(Vector3.zero)
    val expected = AimedPosition(Vector3(0, 0, 5), 0)
    val actual = initialPosition + Vector3.forward * 5
    actual should be (expected)
  }

  "Solution2.AimedPosition" should "move down properly" in {
    val initialPosition = AimedPosition(Vector3(0, 0, 5), 0)
    val expected = AimedPosition(Vector3(0, 0, 5), 5)
    val actual = initialPosition + Vector3.down * 5
    actual should be (expected)
  }

  "Solution2.solveFor" should "find correct result for example input" in {
    Solution2().solveFor(input) should be (900)
  }
}
