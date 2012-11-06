package com.knoldus.caketest

object RepeatedComposition extends App {

  // Exercise 1.43

  /**
   * Square of a number
   */
  def square(x: Int) = x * x

  /**
   * Takes one argument functions f and a positive integer n for nth repeated function
   * Returns itself until n=1
   */
  def compose(f: Int => Int, x: Int, n: Int): Int = {
    n match {
      case 0 => x
      case 1 => f(x)
      case _ => compose(f, f(x), n - 1)
    }
  }

  /**
   * Takes one argument functions f and a positive integer n for nth repeated function
   * Returns compose for computing value for input x nth times
   */
  def repeated(f: Int => Int, n: Int) = {
    x: Int => compose(f, f(x), n - 1)
  }

  println(repeated(square, 2)(5)) //Output is 625

  println(repeated(square, 1)(5)) //Output is 25

  println(repeated(square, 2)(2)) //Output is 16

  println(repeated(square, 2)(3)) //Output is 81

}