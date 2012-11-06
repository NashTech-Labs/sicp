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
  def repeated(f: Int => Int, n: Int) = {

    def rep(g: Int => Int, i: Int): Int => Int = i match {

      case 1 => x => g(x)

      case _ => rep(f compose g, i - 1)

    }

    rep(f, n)

  }

  println(repeated(square, 1)(5)) // should be equal to 25

  println(repeated(square, 2)(5)) // should be equal to 625

  println(repeated(square, 2)(2)) // should be equal to 16

  println(repeated(square, 2)(3)) // should be equal to 81

}