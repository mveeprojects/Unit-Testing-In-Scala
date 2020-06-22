import org.scalatest.flatspec.AnyFlatSpec

class HelloWorldSpec extends AnyFlatSpec {

  behavior of "helloworld"

  it should "start with hello" in {
    assert("helloworld" startsWith "hello")
  }


  it should "end with world" in {
    assert("helloworld" endsWith "world")
  }

}
