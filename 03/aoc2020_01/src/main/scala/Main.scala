import scala.io.Source

object Main extends App {
  def check(l: String, y: Int): Int = {
    if (l(y) == '#') 1 else 0
  }

  def count(lines: Array[String], yInc: Int, xInc: Int): Long = {
    var result = 0
    var curX = 0
    var curY = 0
    while (curX < lines.length) {
      result += check(lines(curX), curY)
      curY = (curY + yInc) % lines(curX).length()
      curX += xInc
    }
    result
  }

  def run {
    val bufferedSource = Source.fromFile("in.txt")
    val lines = bufferedSource.getLines().toArray
    bufferedSource.close

    println(
      count(lines, 1, 1) *
      count(lines, 3, 1) *
      count(lines, 5, 1) *
      count(lines, 7, 1) *
      count(lines, 1, 2)
    )
  }
  run
}
