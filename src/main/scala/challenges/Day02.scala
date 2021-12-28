package com.yalingunayer.aoc2021.challenges

import com.yalingunayer.aoc2021.Utils
import com.yalingunayer.aoc2021.RingBuffer

object Day02 extends Challenge(2) {
  case class Counter(increased: Int, decreased: Int, buffer: RingBuffer[Int]) {
    def add(current: Int): Counter =
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
      .foldLeft(Counter(0, 0, RingBuffer.withCapacity(3))) { (counter, current) => counter.add(current) }
      .increased
}
