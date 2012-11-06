package com.knoldus.sicp

//Excercise 1.6

object SquareRootCalculator extends App {

  // ================== Regular If =============================

  /**
    * Finds square root of a given number using Newtons method
    * We always start with 1 as the first guess
    */
  def squareRoot(x : Double) = squareRootCalculator(1.0, x)

  /** Iterative calculation for square root*/
  private def squareRootCalculator(guess : Double, x : Double) : Double = {
    if (isGoodEnough(guess, x)) guess
    else squareRootCalculator(improve(guess, x), x)
  }

  /** Check that the guess is close enough */
  private def isGoodEnough(guess : Double, x : Double) =
    abs(guess * guess - x) < 0.001

  /** Improve the guess following Newtons method */
  private def improve(guess : Double, x : Double) =
    (guess + x / guess) / 2

  private def abs(x : Double) = if (x < 0) -x else x

  // ================== New If condition=============================

  def squareRootWithNewIf(x : Double) = squareRootCalculatorWithNewIf(1.0, x)

  /** new if which returns consequent or alternative based on the predicate */
  private def newIf(isPredicateTrue : Boolean, consequent : Double, alternative : Double) = { if (isPredicateTrue) consequent else alternative }

  /** Iterative calculation for square root with new if*/
  private def squareRootCalculatorWithNewIf(guess : Double, x : Double) : Double = {
    newIf(isGoodEnough(guess, x), guess, squareRootCalculatorWithNewIf(improve(guess, x), x))
  }

  println(squareRoot(2)) // Output = 1.4142156862745097
  println(squareRootWithNewIf(2)) // Would fail

  // Reason

  /* Evaluator  would throw an Exception telling  Output exceeds cutoff limit.
   * This is because "if" has special handling, where in if the predicate evaluates to true, the consequent would be evaluated else alternate is evaluated.
   * newIf, does not have this special handling and the else part is also evaluated using applicative order evaluation
  */

}
