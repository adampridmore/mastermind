package mastermind

case class Row(pegs: List[Colour]) {
  override def toString: String = pegs.mkString(",")
}

object Row {
  def apply(first: Colour, second: Colour, third: Colour, fourth: Colour) : Row = Row(List(first, second, third, fourth))
}

