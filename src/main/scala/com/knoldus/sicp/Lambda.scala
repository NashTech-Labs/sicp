package com.knoldus.sicp

object Lambda extends App {

  // Exercise 1.34  

  /**
    * Pass an Integer function  as an argument in function "f"
    * return passed function with parameter 2
    */

  def f(g : Int => Int) = g(2)

  /**
    * Square of a number
    */
  def square(x : Int) = x * x

  println(f(square)) //output is 4

  val lambda = (x: Int) => x*(x + 1)
  println(f(lambda))// output is 6

  /**
    * Now pass function f as an argument in function f
    */
  
 // println(f(f)) - Does not compile!

  /**
    * error: type mismatch;
    * found   : Int => Int => Int
    * required: Int => Int
    * f(f)
    *
    * ========================================================================
    * 1) f receives a function f, as its argument.
    * 2) That causes error of type mismatch
    */

}