
object NumberNotations {

  val englandShort = List("sextillion",
    "quintillion",
    "quadrillion",
    "trillion",
    "billion",
    "million",
    "thousand")

  val european = List("trilliard",
    "trillion",
    "billiard",
    "billion",
    "milliard",
    "million",
    "thousand")

  def notationSplit(num: String): List[String] = {
    num.reverse.grouped(3).toList.map(_.reverse.toList.mkString("")).reverse
  }

  def stringBuild(list: List[String]): String = {
    def buildRecursively(list: List[String], result: String = ""): String = {
      list.headOption match {
        case Some(_) => buildRecursively(list.tail, result + list.head)
        case None => result
      }
    }

    buildRecursively(list)
  }

  def getLongNum(list: List[String], words: List[String]): String = {
    val therest = list.drop(list.length - 8)
    val printable = list.take(list.length - 8).mkString("") +:
      (for (triplet <- 0 to therest.length - 1) yield {
        if (triplet > therest.length - 2) {
          therest(triplet).replaceFirst("^0*", "")
        }
        else if (therest(triplet).replaceFirst("^0*", "") == "") {
          ""
        }
        else {
          therest(triplet) + " " + words(triplet) + ", "
        }
      }).toList
    stringBuild(printable)
  }

  def printNotations(num: String): Unit = {
    if (num.matches("[0-9]+") || (num.head == '-' && num.tail.matches("[0-9]+"))) {
      num.charAt(0) match {
        case '-' => println("English Notation: -" + getLongNum(notationSplit(num.tail), englandShort))
          println("European Notation: -" + getLongNum(notationSplit(num.tail), european))
        case _ => println("English Notation: " + getLongNum(notationSplit(num), englandShort))
          println("European Notation: " + getLongNum(notationSplit(num), european))
      }
    } else {
      println("Please enter only a number.")
    }
  }


  def main(args: Array[String]): Unit = {
    printNotations("-9453453457623453")
  }
}
