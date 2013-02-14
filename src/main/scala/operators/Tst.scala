package operators

case class Tst(s: String) {
  def +++(other: Tst) = Tst("(%s+++%s)".format(this.toString, other.toString))
  def ***(other: Tst) = Tst("(%s***%s)".format(this.toString, other.toString))
  def ###(other: Tst) = Tst("(%s###%s)".format(this.toString, other.toString))

  override def toString: String = s
}
