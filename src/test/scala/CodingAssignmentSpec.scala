import CodingAssignment.{Transaction, averageSpendPerTransactionCategory, totalTransactionAmountByDay}
import org.scalatest.freespec.AnyFreeSpec

class CodingAssignmentSpec extends AnyFreeSpec {

  val testData: List[Transaction] = List(
    Transaction(transactionId = "t001", accountId = "a001", transactionDay = 1, category = "AA", transactionAmount = 1.0),
    Transaction(transactionId = "t002", accountId = "a002", transactionDay = 1, category = "CC", transactionAmount = 2.0),
    Transaction(transactionId = "t003", accountId = "a001", transactionDay = 1, category = "FF", transactionAmount = 3.0),
    Transaction(transactionId = "t004", accountId = "a002", transactionDay = 1, category = "AA", transactionAmount = 5.0),
    Transaction(transactionId = "t005", accountId = "a001", transactionDay = 1, category = "CC", transactionAmount = 10.0),
    Transaction(transactionId = "t006", accountId = "a002", transactionDay = 2, category = "FF", transactionAmount = 2.0),
    Transaction(transactionId = "t007", accountId = "a001", transactionDay = 2, category = "AA", transactionAmount = 4.0),
    Transaction(transactionId = "t008", accountId = "a002", transactionDay = 2, category = "CC", transactionAmount = 6.0),
    Transaction(transactionId = "t009", accountId = "a001", transactionDay = 2, category = "FF", transactionAmount = 8.0),
    Transaction(transactionId = "t0010", accountId = "a002", transactionDay = 2, category = "AA", transactionAmount = 10.0)
  )

  //QUESTION 1
  "totalTransactionAmountByDay" -  {
    "must return the correct total for each day" - {

      val testTotalByDay: Map[Int, Double] = totalTransactionAmountByDay(testData)

      "for day 1" in {
        assert(testTotalByDay(1) == 21.0)
      }
      "for day 2" in {
        assert(testTotalByDay(2) == 30.0)
      }
    }
  }

  //QUESTION 2
  "groupByAccountByCategory" - {
    "must return the correct total spent for each category for every account" - {

      val testAverageSpendPerCategory: Map[String, Map[String, Double]] = averageSpendPerTransactionCategory(testData)

      "for account a001" - {
        "category AA" in {
          assert(testAverageSpendPerCategory("a001")("AA") == 2.5)
        }
        "category CC" in {
          assert(testAverageSpendPerCategory("a001")("CC") == 10.0)
        }
        "category FF" in {
          assert(testAverageSpendPerCategory("a001")("FF") == 5.5)
        }
      }

      "for account a002" - {
        "category AA" in {
          assert(testAverageSpendPerCategory("a002")("AA") == 7.5)
        }
        "category CC" in {
          assert(testAverageSpendPerCategory("a002")("CC") == 4.0)
        }
        "category FF" in {
          assert(testAverageSpendPerCategory("a002")("FF") == 2.0)
        }
      }
    }
  }
}
