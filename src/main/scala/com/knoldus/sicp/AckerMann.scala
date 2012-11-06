package com.knoldus.sicp

object AkerMann extends App {

  // Exercise 1.10 
  //AckerMann's Function
  def A(x: BigInt, y: BigInt): BigInt = {
    if (y == 0) 0
    else if (x == 0) y * 2
    else if (y == 1) 2
    else A(x - 1, A(x, y - 1))
  }

  // procedure f(n)

  def f(n: BigInt) = A(0, n)  // computes 2n

  //Procedure g(n)

  def g(n: BigInt) = A(1, n)  // computes 2^n

  //Procedure h(n)

  def h(n: BigInt) = A(2, n) // computes 2 ^ h(n - 1)

  // Procedure h(n)

  def k(n: BigInt) = 5 * n * n // computes to 5n^2

  /**
   * Results:
   * 1)
   * scala> A(1,10)
   * res0: BigInt = 1024
   *
   * 2)
   * scala> A(2,4)
   * res1: BigInt = 65536
   *
   * 3)
   * scala> A(3,3)
   * res2: BigInt = 65536
   *
   */
  println(f(4))
  println(g(4))
  println(h(4))

}
