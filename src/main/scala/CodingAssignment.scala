import scala.annotation.tailrec
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
      totalTransactionAmountByDay(transactions).foreach{
        case (day, total) => println(s"Day $day - £$total")
      }

    val question2: Unit =
      averageSpendPerTransactionCategory(transactions).foreach(println(_))

    val question3: Unit = {
      println(s"Day,Account Id,Maximum,Average,AA Total Value,CC Total Value,FF Total Value")
      1 to 30 foreach { day =>
        transactionDetailsByAccountPerDay(transactions, day).foreach(x =>
          println(s"${x.day},${x.accountId},${x.max},${x.average},${x.aa},${x.cc},${x.ff}")
        )
      }
    }
  }

  //QUESTION 1
  //Groups by transaction day, then maps the transaction amount for each day and sums it up
  def totalTransactionAmountByDay(transactions: List[Transaction]): Map[Int, Double] =
    transactions.groupMapReduce(_.transactionDay)(_.transactionAmount)(_ + _)


  //QUESTION 2
  //Grouping the transactions by accountId
  def averageSpendPerTransactionCategory(transactions: List[Transaction]): Map[String, Map[String, Double]] = {
    transactions.groupBy(_.accountId).map {
      case (key, value) =>
        (key, value.map(x =>                                                //Mapping the value to keep only the category and transactionAmount
          (x.category, x.transactionAmount)
        ).groupBy(_._1).map {                                               //Grouping by the category
          case (key, value) => (key, value.map(_._2).sum / value.length)    //Calculating the average transaction value
        }
        )
    }
  }

  //QUESTION 3
  //CASE CLASS FOR THE RETURN TYPE
  case class TransactionDetails(
                                 day: Int,
                                 accountId: String,
                                 max: Double,
                                 average: Double,
                                 aa: Double,
                                 cc: Double,
                                 ff: Double
                               )


  def transactionDetailsByAccountPerDay(transactions: List[Transaction], day: Int): Seq[TransactionDetails] = {
    val start = if (day <= 5) 1 else day - 5                        //calculates the start date for the rolling window
    val range: Seq[Int] = start until day                           //creates a range of days

    val transactionsInRollingWindow: Seq[Transaction] = range.flatMap(transactions.groupBy(_.transactionDay)(_))        //creating a list of transactions for the rolling time window
    val ids: Seq[String] = transactionsInRollingWindow.map(_.accountId).distinct                                        //getting all the unique IDs
    val transactionsGroupedByAccount: Map[String, Seq[Transaction]] = transactionsInRollingWindow.groupBy(_.accountId)  //grouping the transactions by IDs

    val solver = ids.map(id => {                                    //Mapping for each Id
      val initialTransactions = transactionsGroupedByAccount(id)    //Passing the Id into the map to return a seq of transactions for that ID (for given day)

      @tailrec
      def transactionStatistics(transactions: Seq[Transaction], max: Double = 0, total: Double = 0,
                                count: Int = 0, aa: Double = 0.0, cc: Double = 0.0, ff: Double = 0.0): TransactionDetails = {
        transactions.headOption match {                                                                         //getting the head value as an optional and creating a match case
          case Some(transaction) =>                                                                             //if head returns a value match this case
            val newMax = if (transaction.transactionAmount > max) transaction.transactionAmount else max        //for each transaction value, keeps larger one
            val newTotal = total + transaction.transactionAmount                                                //Keeps a sum of the total transaction value for average
            val newCount = count + 1                                                                            //Keeping count of transactions for average
            val newAA = if (transaction.category == "AA") aa + transaction.transactionAmount else aa            //Adds transactionAmount to category if matches
            val newCC = if (transaction.category == "CC") cc + transaction.transactionAmount else cc            //Adds transactionAmount to category if matches
            val newFF = if (transaction.category == "FF") ff + transaction.transactionAmount else ff            //Adds transactionAmount to category if matches

            transactionStatistics(transactions.tail, newMax, newTotal, newCount, newAA, newCC, newFF)           //Calls itself with the tail of the sequence and the updated values
          case None => TransactionDetails(day, id, max, total / count, aa, cc, ff)                              //Returns the values when no more transactions are left in the sequence
        }
      }
      transactionStatistics(initialTransactions)                      //Calling the recursive method with the initial seq of transactions
    })
    solver
  }
}
