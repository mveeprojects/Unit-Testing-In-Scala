package matchers

import com.h2.services.Currency

class EqualitySpec extends UnitSpec {

  /**
    * Array(100, 200) == Array(100, 200) => false
    * this is because Array comparison is instance-based comparison rather than value-based
    *
    * With Scalatest you can however compare two arrays to check they have the same values
    * Array(100, 200) should equal (Array(100, 200)) => true
    *
    * The below are slower to compile but allow customisation (utilises implicit conversions (Equality[T]))
    * "" should equal ""
    * "" should === "" -> checks type equality at compile time (e.g. String comparing to String)
    * "" should be ""
    *
    * The below are the fastest to compile as not looking for any implicit conversions (Equality[T])
    * "" shouldEqual ""
    * "" shouldBe ""
    */

  behavior of "currency equals"

  it should "match 2 £ values as the same when their values are equal" in {
    val c1: Currency = "1 GBP"
    val c2: Currency = "1 GBP"
    c1 should equal(c2)
    c1 should ===(c2)
    c1 shouldEqual c2
    c1 shouldBe c2
    c1 should be(c2)
  }
}
