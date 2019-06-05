package mastermind

trait Colour

object Colour {
  def apply(s: String) = s.toUpperCase match {
    case "RED" | "R" => Colours.Red
    case "YELLOW" | "Y" => Colours.Yellow
    case "ORANGE" | "O" => Colours.Orange
    case "GREEN" | "G" => Colours.Green
    case "BLACK" | "B" => Colours.Black
    case "WHITE" | "W" => Colours.White
    case invalid => throw new IllegalArgumentException(s"Invalid colour: $invalid")
  }
}

object Colours {

  case object Red extends Colour

  case object Yellow extends Colour

  case object Orange extends Colour

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

