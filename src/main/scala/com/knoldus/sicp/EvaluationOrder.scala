package com.knoldus.sicp

object EvaluationOrder extends App {

  // Exercise 1.5 

  //Case I - Applicative order evaluation (would not terminate)
  def p : Int = p
  def test(x : Int, y : Int) = { println("Non terminating"); if (x == 0) 0 else y }

  test(0, p) // Would not terminate since p is also evaluated - 

  // Case II - Converting the second parameter to normal order evaluation
  def testTerminating(x : Int, y : => Int) = { println("Would terminate"); if (x == 0) 0 else y }

  testTerminating(0, p)

  // Case III - passing a function allows evaluation when needed hence would terminate as well
  def myFunction() : Unit = myFunction
  def testTerminatingWithFunction(x : Int, y : () => Unit) = { println("Would terminate"); if (x == 0) 0 else y }
  
  testTerminatingWithFunction(0, myFunction)

}