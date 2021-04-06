import scala.io.Source

object Main extends App {
  def triad(arr1: List[Int], arr2: List[Int], target: Int): Option[Int] = {
    arr1 match {
      case Nil => None
      case head :: next =>
        if (pair(arr2, arr2, target - head).isDefined)
          Option(head * pair(arr2, arr2, target - head).get)
        else
          triad(next, arr2, target)
    }
  }

  def pair(arr1: List[Int], arr2: List[Int], target: Int): Option[Int] = {
    arr1 match {
      case Nil => None
      case x :: rest =>
        if (find_pair(x, rest, target).isDefined)
          find_pair(x, arr2, target)
        else
          pair(rest, arr2, target)
    }
  }

  def find_pair(el: Int, arr: List[Int], target: Int): Option[Int] = {
    arr match {
      case Nil => None
      case x :: rest =>
        if (el + x == target) Option(el * x) else find_pair(el, rest, target)
    }
  }

  def run {
    val bufferedSource = Source.fromFile("in.txt")
    val lines = bufferedSource.getLines().toList.map(_.toInt)
    bufferedSource.close

    println(pair(lines, lines, 2020).get)
    println(triad(lines, lines, 2020).get)
  }
  run
}
