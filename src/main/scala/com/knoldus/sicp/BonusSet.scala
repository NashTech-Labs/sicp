package com.knoldus.sicp

object BonusSet extends App {

  /** Limit for iteration */
  val limit = 1000

  // define the Set type
  type MySet = Int ⇒ Boolean

  //Check if the element exists in the set
  def exists(set : MySet, element : Int) : Boolean = set(element)

  /**
    * For all elements in a set check if the predicate is true
    */
  def forall(predicate : (Int) ⇒ Boolean, set : MySet) : Boolean = {
      def iter(element : Int) : Boolean = {
        //println("iterating with " + element)
        if (exists(set, element) && !predicate(element)) false
        else if (element < -limit) true // break the loop here
        else iter(element - 1)
      }
    iter(limit)
  }

  // Set containing values [12]
  val set1 = (x : Int) ⇒ x == 12
  val predicate1 = (x : Int) ⇒ x > 11
  println(forall(predicate1, set1))

  // Set containing values [0]
  val set2 = (x : Int) ⇒ x == 0
  val predicate2 = (x : Int) ⇒ x == 0
  println(forall(predicate2, set2))

  // Set containing values [0,1,2,3,4]
  val set3 = (x : Int) ⇒ 0 <= x && x <= 4
  val predicate3 = (x : Int) ⇒ x >= 1
  println(forall(predicate3, set3))

  // Set containing values [1,2,3,4]
  val set4 = (x : Int) ⇒ 1 <= x && x <= 4
  val predicate4 = (x : Int) ⇒ x >= 1
  println(forall(predicate4, set4))

  // Set containing values [1001,1002] would return true by default since it is outside the limit
  val set5 = (x : Int) ⇒ 1001 <= x && x <= 1002
  val predicate5 = (x : Int) ⇒ x >= 1
  println(forall(predicate5, set5))

  
}