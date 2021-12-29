package com.yalingunayer.aoc2021.solutions

import scala.collection.BitSet
import com.yalingunayer.aoc2021.Utils

object Day03 {
  def parseBitSet(input: String): BitSet = BitSet.fromSpecific(input.toCharArray.map(_.toInt).toSeq)

  case class BitCounter(counts: Vector[Int]) {
    type Zipped = (Int, Int)

    def +(bitSet: BitSet): BitCounter =
      val zipped: Seq[Zipped] = bitSet.toSeq.zip(counts)
      val keke = zipped.map(z => z._1 + z._2)
      val newCounts = Vector(keke)
      BitCounter(counts)

    def mostCommonBits(): BitSet =
      val halfSize = counts.size / 2
      val bits = counts.map(count => if count <= halfSize then 0 else 1)
      BitSet.fromSpecific(bits.toSeq)
  }

  object BitCounter {
    def withByteLength(capacity: Int): BitCounter = BitCounter(Vector.fill(capacity)(0))
  }

  case class Solution1() extends Solution {

    def solveFor(input: LazyList[BitSet]): Int =
      def counts = input.foldLeft(BitCounter.withByteLength(12))((counter, bitset) => counter + bitset)
      def mostCommon = counts.mostCommonBits()
      println(f"$mostCommon")
      42

    override def solve(): Int =
      def input = Utils.readInput("day03.txt").map(parseBitSet)
      solveFor(input)
  }
}
