import scala.io.Source
import java.util.LinkedHashMap

object Main extends App {
  def count(map: Map[String, String], required: List[String]): Boolean = {
    required match {
      case Nil=> true
      case head:: next => if (map.contains(head)) count(map, next) else false
    }
  }
  def count(line: String) : Int = {
    val pairs = line.trim.split(" |:").grouped(2)
    val map = pairs.map { case Array(k, v) => k -> v }.toMap
    val required = List("ecl", "pid", "eyr", "hcl", "byr", "iyr", "hgt")
    if (count(map, required)) 1 else 0
  }

  def count(line: String, lines: List[String]): Int = {
    lines match {
      case Nil => count(line)
      case head :: next => 
        if (head == "") 
          count(line) + count(head, next) 
        else
          count(line + " " + head, next) 
    }
  }

  def run {
    val bufferedSource = Source.fromFile("in.txt")
    val lines = bufferedSource.getLines().toList
    bufferedSource.close

    println(count("", lines))
  }
  run
}
