import scala.io.Source

object CodingAssignment {

  case class Transaction(
                          transactionId: String,
                          accountId: String,
                          transactionDay: Int,
                          category: String,
                          transactionAmount: Double
                        )

  //The full path to the file to import
  val fileName = "assets/transactions.txt"

  //The lines of the CSV file (dropping the first to remove the header)
  val transactionsLines: Iterator[String] = Source.fromFile(fileName).getLines().drop(1) //Here we split each line up by commas and construct Transactions
  val transactions: List[Transaction] = transactionsLines.map { line =>
      val split = line.split(',')
      Transaction(split(0), split(1), split(2).toInt, split(3), split(4).toDouble)
    }.toList

  def main(args: Array[String]): Unit = {
    val question1: Unit =
      totalTransactionAmountByDay(transactions).map{
        case (day, total) => println(s"Day $day - £$total")
      }
  }

  //QUESTION 1
  //Groups by transaction day, then maps the transaction amount for each day and sums it up
  def totalTransactionAmountByDay(transactions: List[Transaction]): Map[Int, Double] = transactions.groupMapReduce(_.transactionDay)(_.transactionAmount)(_ + _)

}
