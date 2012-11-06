package com.knoldus.sicp

object ReturnAProcess extends App {

  // Exercise 1.41

  /**
   * Takes argument and adds 1 to its argument
   */
  def inc(x: Int) = x + 1
  

  /**
   * Takes a function as Argument
   * and returns a function that applies the original function twice
   */
  def double[T] (f: (T) => T) = (x:T) => f(f(x))  //> double: [T](f: T => T)T => T


  println(double(inc)(6)) // increment applied twice hence 8
  
  println(double(double(double[Int]))(inc)(5)) //21
}
