import scala.io.Source

object Main extends App {
  def validate2(item: (Int, Int, Char, String)): Int = {
    if (item._4.charAt(item._1-1) == item._3 ^ item._4.charAt(item._2-1) == item._3) 1 else 0
  }
  
  def validate1(item: (Int, Int, Char, String)): Int = {
    val c = item._4.count(_ == item._3)
    if (item._1 <= c && c <= item._2) 1 else 0
  }

  def count(list: List[(Int, Int, Char, String)], fun: ((Int, Int, Char, String)) => Int): Int = {
    list match {
      case Nil => 0
      case head :: next => fun(head) + count(next, fun(_))
    }
  }

  def run {
    val bufferedSource = Source.fromFile("in.txt")
    val lines = bufferedSource.getLines().toArray
    bufferedSource.close

    val list = lines.collect(_.replace('-', ' ').replace(':', ' ').split(' ') match {
      case Array(f, t, c, s1, s2) => (f.toInt, t.toInt, c.toCharArray()(0), s2)
    }).toList
    
    println(count(list, validate1(_)))
    println(count(list, validate2(_)))
  }
  run
}
