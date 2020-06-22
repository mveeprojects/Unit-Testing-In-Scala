package com.h2.entities

import org.scalatest.flatspec.AnyFlatSpec

class DollarsSpec extends AnyFlatSpec {

  behavior of "Dollar"

  it should "be able to create a Dollar object given input 10" in {
    val dollars = Dollars(10)
    assert("$10" === dollars.toString)
  }

  it should "correctly identify that $10 > $5" in {
    val fiveDollars = Dollars(5)
    val tenDollars = Dollars(10)
    assert(tenDollars > fiveDollars)
  }

  it should "correctly identify that $1 < $5" in {
    val fiveDollars = Dollars(5)
    val oneDollar = Dollars(1)
    assert(oneDollar < fiveDollars)
  }

  it should "correctly add 2 dollars amounts" in {
    val fiveDollars = Dollars(5)
    val oneDollar = Dollars(1)
    assertResult("$6") {
      (fiveDollars + oneDollar).toString
    }
  }

  it should "correctly subtract 2 dollars amounts" in {
    val fiveDollars = Dollars(5)
    val oneDollar = Dollars(1)
    assertResult("$4") {
      (fiveDollars - oneDollar).toString
    }
  }

  it should "correctly identify equal dollar amounts" in {
    val fiveDollars = Dollars(12)
    val oneDollar = Dollars(12)
    assertResult(true) {
      fiveDollars == oneDollar
    }
  }

  it should "throw an exception on invalid input" in {
    withClue("this test will fail if you divide a number by zero") {
      assertThrows[ArithmeticException] {
        Dollars(10 / 0)
      }
    }
  }

  it should "ensure every dollar object has a value greater than 0" in {
    //    val dollarList = List(Dollars(3), Dollars(12), Dollars(100))
    val dollarList = List.empty[Dollars]

    assume(dollarList.nonEmpty, "the dollarList is empty make sure you add Dollars objects to it!") // precondition check to cancel test early if required condition is not met

    dollarList.foreach { d =>
      assert(d.amount > 0, "make sure all dollar amounts are greater than zero")
    }
  }
}
