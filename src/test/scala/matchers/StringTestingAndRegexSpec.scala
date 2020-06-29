package matchers

import java.util.UUID

import com.h2.entities.Customer
import com.h2.services.CustomerService

class StringTestingAndRegexSpec extends UnitSpec {

  val customerService: CustomerService = new CustomerService {}
  val (firstName, lastName, email, dob) = ("Mark", "V", "markv@blah.com", "1234/12/12")
  val customerId: UUID = customerService.createNewCustomer(firstName, lastName, email, dob)
  val customer: Customer = customerService.getCustomer(customerId).get

  behavior of "Strings n tings"

  it should "ensure emails start with the customers first name" in {
    customer.email.toString should startWith(firstName.toLowerCase)
  }

  it should "ensure emails end with '.com'" in {
    customer.email.toString should endWith(".com")
  }

  it should "ensure emails contain '@'" in {
    customer.email.toString should include("@")
  }

  it should "ensure emails match a given pattern (regex)" in {
    customer.email.toString should include regex "[a-z]+[@.]com"
  }

  it should "ensure DOB matches a given pattern (regex)" in {
    customer.dateOfBirth.toString should fullyMatch regex "[0-9]{4}-[0-9]{2}-[0-9]{2}"
  }

  it should "abc should be less than def" in {
    "abc" should be < "def"
  }
}
