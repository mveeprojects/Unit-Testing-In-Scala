package matchers

import java.util.UUID

import com.h2.entities.Customer
import com.h2.services.CustomerService

class LengthAndSizeSpec extends UnitSpec {

  val MyCustomerService: CustomerService = new CustomerService {}

  behavior of "CustomerService length tests"

  // demonstrating usage of the "have" keywords "length" function
  it should "return the correct length for a customers name" in {
    val (firstName, lastName, email, dob) = ("Mark", "V", "markv@blah.com", "1234/12/12")
    val customerId: UUID = MyCustomerService.createNewCustomer(firstName, lastName, email, dob)
    val customer: Customer = MyCustomerService.getCustomer(customerId).get
    customer.first should have length firstName.length
    customer.last should have length lastName.length
  }

  // demonstrating usage of the "have" keywords "size" function
  behavior of "CustomerService size tests"

  it should "return the correct size of a list of customerIds" in {
    val customerIdList = List(
      MyCustomerService.createNewCustomer("Mark", "V", "markv@blah.com", "1234/12/12"),
      MyCustomerService.createNewCustomer("Mary", "V", "maryv@blah.com", "1234/12/12")
    )
    customerIdList should have size 2
  }
}
