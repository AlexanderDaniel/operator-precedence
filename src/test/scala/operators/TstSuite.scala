package operators

import org.scalatest.FunSuite

class TstSuite extends FunSuite {

  test("+++") {
    val result = Tst("a") +++ Tst("b")
    assert(result.s === "(a+++b)")
  }

  test("***") {
    val result = Tst("a") *** Tst("b")
    assert(result.s === "(a***b)")
  }

  test("*** with three operands") {
    val result = Tst("a") *** Tst("b") *** Tst("c")
    assert(result.s === "((a***b)***c)")
  }

  test("operator precedence") {
    val result = Tst("a") +++ Tst("b") *** Tst("c")
    assert(result.s === "(a+++(b***c))")
  }
}
