package com.knoldus.sicp

object Composition extends App {

  // Exercise 1.42

  /**
   * Compute square of a number
   */
  def square(x: Int) = x * x

  /**
   * Takes argument and adds 1 to its argument
   */
  def inc(x: Int) = x + 1

  /**
   * Take one argument functions f and g as argument
   * And implement composition x -> f(g(x))
   */
  def compose(f: Int => Int, g: Int => Int): Int => Int =   x => f(g(x))

  println(compose(square , inc)(6))  // Output is 49
}