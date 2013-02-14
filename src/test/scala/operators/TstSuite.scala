package operators

import org.scalatest.FunSuite

/**
 * First character of a method defines the precedence:
 * {{{
 * all other special characters
 * / %
 * + -
 * :
 * = !
 * < >
 * &
 * ^
 * |
 * all letters
 * all assignment operators
 * }}}
 */
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

  test("* has higher precedence that +") {
    val result = Tst("a") +++ Tst("b") *** Tst("c")
    assert(result.s === "(a+++(b***c))")
  }

  test("other special characters have higher precedence that *") {
    val result = Tst("a") *** Tst("b") ### Tst("c")
    assert(result.s === "(a***(b###c))")
  }
}
