package com.yalingunayer.aoc2021

case class Vector3(x: Double, y: Double, z: Double) {
  def +(v: Vector3): Vector3 = Vector3(x + v.x, y + v.y, z + v.z)
  def -(v: Vector3): Vector3 = Vector3(x - v.x, y - v.y, z - v.z)
  def *(k: Double): Vector3 = Vector3(x * k, y * k, z * k)

  override def toString: String = f"($x, $y, $z)"
}

object Vector3 {
  def up: Vector3 = Vector3(0, -1, 0)
  def down: Vector3 = Vector3(0, 1, 0)
  def forward: Vector3 = Vector3(0, 0, 1)
  def backwards: Vector3 = Vector3(0, 0, -1)
  def zero: Vector3 = Vector3(0, 0, 0)
}
