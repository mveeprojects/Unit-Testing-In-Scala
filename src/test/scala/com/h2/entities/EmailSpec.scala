package com.h2.entities

import org.scalatest.flatspec.AnyFlatSpec

class EmailSpec extends AnyFlatSpec {

  behavior of "An Email"

  it should "return a Email object for a valid String" in {
    val email = Email("bob@fred.com")
    assert(email.localPart === "bob")
    assert(email.domain === "fred.com")
  }

  it should "return another email object for another valid string" in {
    assertResult("jim") {
      Email("jim@john.com").localPart
    }
  }

  it should "throw an exception when an email that does not contain an @ symbol is provided" in {
    assertThrows[IllegalArgumentException] {
      Email("jim")
    }
  }

  it should "produce the correct error message when an email that does not contain an @ symbol" in {
    val actual = intercept[IllegalArgumentException] {
      Email("jim")
    }
    assert(actual.isInstanceOf[IllegalArgumentException])
    assert(actual.getMessage.contains("invalid email: does not contain '@' symbol"))
  }

  it should "throw an exception when an email that contains more than one @ symbol is provided" in {
    assertThrows[IllegalArgumentException] {
      Email("jim@@jim.com")
    }
  }

  it should "produce the correct error message when an email that contains more than one @ symbol is provided" in {
    val actual = intercept[IllegalArgumentException] {
      Email("jim@@jim.com")
    }
    assert(actual.isInstanceOf[IllegalArgumentException])
    assert(actual.getMessage.contains("invalid email: should not contain '@' symbol more than once"))
  }

//  it should "do something that isn't implemented yet" in {
//    fail("this test is not implemented yet")
//  }

  ignore should "do something that isn't implemented yet" in {
    fail("this test is being ignored for the moment")
  }
}
