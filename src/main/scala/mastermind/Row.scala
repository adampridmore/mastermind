package mastermind

case class Row[T](pegs: List[T]) {
  override def toString: String = pegs.mkString(",")
}

object Row {
  def apply[T](first: T, second: T, third: T, fourth: T) : Row[T] = Row[T](List(first, second, third, fourth))
}

