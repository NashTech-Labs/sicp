package com.knoldus.sicp

object InfiniteContinuedFraction extends App {

  //Exercise 1.38

  /**
    * function infinite continued fraction limited by k
    */
  def continuedFraction(numeratorGenerator : (Int) => Double, denominatorGenerator : (Int) => Double, limitingFactor : Int) = {
      def continuedFractionIterator(iterator : Int) : Double = {
        if (iterator == limitingFactor)
          numeratorGenerator(iterator) / denominatorGenerator(iterator)
        else
          numeratorGenerator(iterator) / (denominatorGenerator(iterator) + continuedFractionIterator(iterator + 1))
      }
    continuedFractionIterator(1)
  }

  /**
    * numerator generator function in each continued fraction. In this case it's all 1
    */
  val numeratorOne : (Int) => Double = (n : Int) => 1.0

  /**
    * generating series for denominator for e
    */
  def denominatorGenerator(i : Int) = (2 * (i + 1)) / 3

  /**
    * calculating natural e using all Ni's as 1 and all Di's as function
    */
  def e(n : Int) = 2 + continuedFraction(numeratorOne, denominatorGenerator, n)

  println("value of e for n=9 " + e(9)) // 2.708715596330275
}