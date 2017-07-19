import org.scalatest.FunSuite
//sbt clean coverage test, followed by sbt coverageReport in terminal give 95%+ test coverage for this project
//Because of compatibility issues in the plugin version, running these test outside of terminal fails them
//Run "sbt clean coverage test" to test, and "sbt coverageReport"

class NumberNotationsTest extends FunSuite{test("Values initialised correctly"){
  assert(NumberNotations.englandShort(0) == "sextillion")
  assert(NumberNotations.englandShort(0).isInstanceOf[String])
  assert(NumberNotations.englandShort.isInstanceOf[List[String]])
  println("English Notations Initialised Correctly")
  assert(NumberNotations.european(0) == "trilliard")
  assert(NumberNotations.european(0).isInstanceOf[String])
  assert(NumberNotations.european.isInstanceOf[List[String]])
  assert(NumberNotations.englandShort(0).isInstanceOf[String])
  println("European Notations Initialised Correctly")
}

  test("notationSplit Works") {
    val lnTest = NumberNotations.notationSplit("1234567890")
    assert(lnTest(0) == "1")
    assert(lnTest(1) == "234")
    assert(lnTest(2) == "567")
    assert(lnTest(3) == "890")
    println("notationSplit Test Passed")
  }

  test("stringBuilder Works") {
    val stringList = List("This ", "Recursive ", "Function ", "Works")
    val sbTest = NumberNotations.stringBuild(stringList)
    assert(sbTest == "This Recursive Function Works")
    assert(sbTest.isInstanceOf[String])
    println("stringBuilder Test Passed")
  }

  test("getLongNumber Works") {
    val words = List("the",
      "quick",
      "brown",
      "fox",
      "jumps",
      "over",
      "dogs")
    val numberList = List("100", "200", "300", "400", "500", "600", "700")
    val result = NumberNotations.getLongNum(numberList, words)
    assert(result.isInstanceOf[String])
    assert(result == "100 the, 200 quick, 300 brown, 400 fox, 500 jumps, 600 over, 700")
    println("getLongNumber Test Passed")
  }

  test("printNotations Works") {
    NumberNotations.printNotations("1234567890")
    NumberNotations.printNotations("-1234567890")
    NumberNotations.printNotations("123456werger7890")
  }

}
