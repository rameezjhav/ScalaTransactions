import CodingAssignment._
import org.scalatest.freespec.AnyFreeSpec

class CodingAssignmentSpec extends AnyFreeSpec {

  val testData: List[Transaction] = List(
    Transaction(transactionId = "t001", accountId = "a001", transactionDay = 1, category = "AA", transactionAmount = 2.0),
    Transaction(transactionId = "t002", accountId = "a002", transactionDay = 1, category = "CC", transactionAmount = 2.0),
    Transaction(transactionId = "t003", accountId = "a001", transactionDay = 1, category = "FF", transactionAmount = 3.0),
    Transaction(transactionId = "t004", accountId = "a002", transactionDay = 1, category = "AA", transactionAmount = 5.0),
    Transaction(transactionId = "t005", accountId = "a001", transactionDay = 1, category = "CC", transactionAmount = 10.0),
    Transaction(transactionId = "t006", accountId = "a002", transactionDay = 2, category = "FF", transactionAmount = 2.0),
    Transaction(transactionId = "t007", accountId = "a001", transactionDay = 2, category = "AA", transactionAmount = 4.0),
    Transaction(transactionId = "t008", accountId = "a002", transactionDay = 2, category = "CC", transactionAmount = 6.0),
    Transaction(transactionId = "t009", accountId = "a001", transactionDay = 2, category = "FF", transactionAmount = 8.0),
    Transaction(transactionId = "t0010", accountId = "a002", transactionDay = 2, category = "AA", transactionAmount = 10.0),
    Transaction(transactionId = "t0011", accountId = "a001", transactionDay = 3, category = "CC", transactionAmount = 5.0),
    Transaction(transactionId = "t0012", accountId = "a002", transactionDay = 3, category = "FF", transactionAmount = 4.0),
    Transaction(transactionId = "t0013", accountId = "a001", transactionDay = 3, category = "AA", transactionAmount = 9.0),
    Transaction(transactionId = "t0014", accountId = "a002", transactionDay = 3, category = "CC", transactionAmount = 1.0),
    Transaction(transactionId = "t0015", accountId = "a001", transactionDay = 3, category = "FF", transactionAmount = 13.0)
  )

  //QUESTION 1
  "totalTransactionAmountByDay" -  {
    "must return the correct total for each day" - {

      val testTotalByDay: Map[Int, Double] = totalTransactionAmountByDay(testData)

      "for day 1" in {
        assert(testTotalByDay(1) == 22.0)
      }
      "for day 2" in {
        assert(testTotalByDay(2) == 30.0)
      }
      "for day 3" in {
        assert(testTotalByDay(3) == 32.0)
      }
    }
  }

  //QUESTION 2
  "groupByAccountByCategory" - {
    "must return the correct total spent for each category for every account" - {

      val testAverageSpendPerCategory: Map[String, Map[String, Double]] = averageSpendPerTransactionCategory(testData)

      "for account a001" - {
        "category AA" in {
          assert(testAverageSpendPerCategory("a001")("AA") == 5.0)
        }
        "category CC" in {
          assert(testAverageSpendPerCategory("a001")("CC") == 7.5)
        }
        "category FF" in {
          assert(testAverageSpendPerCategory("a001")("FF") == 8.0)
        }
      }

      "for account a002" - {
        "category AA" in {
          assert(testAverageSpendPerCategory("a002")("AA") == 7.5)
        }
        "category CC" in {
          assert(testAverageSpendPerCategory("a002")("CC") == 3.0)
        }
        "category FF" in {
          assert(testAverageSpendPerCategory("a002")("FF") == 3.0)
        }
      }
    }
  }

  //QUESTION 3
  "transactionDetailsByAccountPerDay" - {
    "must return the correct transaction details per account for a given day" - {

      val testTransactionDetails: Seq[Seq[TransactionDetails]] = transactionDetailsByAccountPerDay(testData, 4)

      "for day 1" - {
        "account a001" in {
          assert(testTransactionDetails.head.head == TransactionDetails(1, "a001", 10.0, 5.0, 2.0, 10.0, 3.0))
        }
        "account a002" in {
          assert(testTransactionDetails.head(1) == TransactionDetails(1, "a002", 5.0, 3.5, 5.0, 2.0, 0.0))
        }
      }
      "for day 2" - {
        "account a001" in {
          assert(testTransactionDetails(1).head == TransactionDetails(2, "a002", 10.0, 6.0, 10.0, 6.0, 2.0))
        }
        "account a002" in {
          assert(testTransactionDetails(1)(1) == TransactionDetails(2, "a001", 8.0, 6.0, 4.0, 0.0, 8.0))
        }
      }
      "for day 3" - {
        "account a001" in {
          assert(testTransactionDetails(2).head == TransactionDetails(3, "a001", 13.0, 9.0, 9.0, 5.0, 13.0))
        }
        "account a002" in {
          assert(testTransactionDetails(2)(1) == TransactionDetails(3, "a002", 4.0, 2.5, 0.0, 1.0, 4.0))
        }
      }
    }
  }
}
