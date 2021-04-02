import scala.io.Source

object Main extends App {
  val bufferedSource = Source.fromFile("in.txt")
  val lines = bufferedSource.getLines().toArray.map(_.toInt)
  bufferedSource.close

  var result = 0
  for (line1 <- lines) {
    for (line2 <- lines) {
      if (line1 + line2 == 2020)
        result = line1 * line2
    }
  }

  println(result)

  for (line1 <- lines) {
    for (line2 <- lines) {
      for (line3 <- lines) {
        if (line1 + line2 + line3 == 2020)
          result = line1 * line2 * line3
      }
    }
  }
  println(result)
}
