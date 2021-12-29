package com.yalingunayer.aoc2021

import solutions.Day03.*

import org.scalatest.*
import org.scalatest.flatspec.*
import org.scalatest.matchers.*
import scala.collection.BitSet

class Day03Test extends AnyFlatSpec with should.Matchers {
  "parseBitSet" should "parse the given string into a bitset" in {
    val input = "00100"
    val actual = parseBitSet(input)
    val expected = BitSet(00100)
  }

  "BitCounter" should "count up with the given bitset" in {
    val initial = BitCounter.withByteLength(4)
    val actual = initial + BitSet(0101) + BitSet(1101)
    val expected = Vector[Int](1, 2, 0, 2)
    actual.counts should be (expected)
  }

  "solveFor" should "solve for the given input " in {
    val input: LazyList[BitSet] = LazyList(
      BitSet(00100),
      BitSet(11110),
      BitSet(10110),
      BitSet(10111),
      BitSet(10101),
      BitSet(01111),
      BitSet(00111),
      BitSet(11100),
      BitSet(10000),
      BitSet(11001),
      BitSet(00010),
      BitSet(01010)
    )

    val actual = Solution1().solveFor(input)
    actual should be (198)
  }

}
