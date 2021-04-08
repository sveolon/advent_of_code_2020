import scala.io.Source

object Main extends App {
  def validate(item: (Int, Int, Char, String)): Int = {
    val c = item._4.count(_ == item._3)
    if (item._1 <= c && c <= item._2) 1 else 0
  }

  def count(list: List[(Int, Int, Char, String)]): Int = {
    list match {
      case Nil => 0
      case head :: next => validate(head) + count(next)
    }
  }

  def run {
    val bufferedSource = Source.fromFile("in.txt")
    val lines = bufferedSource.getLines().toArray
    bufferedSource.close

    val list = lines.collect(_.replace('-', ' ').replace(':', ' ').split(' ') match {
      case Array(f, t, c, s1, s2) => (f.toInt, t.toInt, c.toCharArray()(0), s2)
    }).toList
    
    println(count(list))
  }
  run
}
