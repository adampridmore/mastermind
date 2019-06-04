package mastermind

trait Colour

object Colour {
  def apply(s: String) = s.toUpperCase match {
    case "RED" => Colours.Red
    case "YELLOW" => Colours.Yellow
    case "BLUE" => Colours.Blue
    case "GREEN" => Colours.Green
    case "BLACK" => Colours.Black
    case "WHITE" => Colours.White
    case invalid => throw new IllegalArgumentException(s"Invalid colour: $invalid")
  }
}

object Colours {

  case object Red extends Colour

  case object Yellow extends Colour

  case object Blue extends Colour

  case object Green extends Colour

  case object Black extends Colour

  case object White extends Colour

}

case class Row(pegs: List[Colour]) {
  override def toString: String = pegs.mkString(",")
}

object Row {
  def apply(first: Colour, second: Colour, third: Colour, fourth: Colour) : Row = Row(List(first, second, third, fourth))
}

