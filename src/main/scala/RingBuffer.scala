package com.yalingunayer.aoc2021

import scala.collection.immutable

type RingLike[T] = immutable.Vector[T]

sealed trait RingBuffer[T] {
  def capacity: Int
  def +(t: T): RingBuffer[T]
  def isFull: Boolean
  def toSeq: Seq[T]
}

object RingBuffer {
  case class RingBufferImpl[T](val capacity: Int, val buffer: RingLike[T]) extends RingBuffer[T] {
    override def isFull: Boolean = buffer.size >= capacity
    override def +(t: T): RingBuffer[T] = RingBufferImpl[T](capacity, (buffer :+ t) takeRight capacity)
    override def toSeq: Seq[T] = buffer.toSeq
  }

  def withCapacity[T](capacity: Int): RingBuffer[T] = RingBufferImpl[T](capacity, immutable.Vector.empty[T])
}
