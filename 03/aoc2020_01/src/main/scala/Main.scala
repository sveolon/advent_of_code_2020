import scala.io.Source

object Main extends App {
  def check(l: String, y: Int): Int = {
    if (l(y) == '#') 1 else 0
  }

  def count(lines: List[String], y: Int): Int = {
    lines match {
      case Nil => 0
      case head :: next => check(head, y) + count(next, (y + 3) % head.length())
    }
  }

  def run {
    val bufferedSource = Source.fromFile("in.txt")
    val lines = bufferedSource.getLines().toList
    bufferedSource.close

    println(count(lines, 0))
  }
  run
}
