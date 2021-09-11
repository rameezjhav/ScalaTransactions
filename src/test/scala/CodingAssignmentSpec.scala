import CodingAssignment._
import org.scalatest.freespec.AnyFreeSpec
import CodingAssignmentConstants.{testData, testDataExtended}

class CodingAssignmentSpec extends AnyFreeSpec {

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
    "must return the correct transaction details for the 5 day rolling window per account for a given day" - {

      val testTransactionDetails: Seq[Seq[TransactionDetails]] = transactionDetailsByAccountPerDay(testDataExtended, 6)

      "for day 6" - {
        "account a001" in {
          assert(testTransactionDetails.head.head == TransactionDetails(6, "a001", 13.0, 7, 38.0, 25.0, 28.0))
        }
        "account a002" in {
          assert(testTransactionDetails.head(1) == TransactionDetails(6, "a002", 10.0, 5.0, 21.0, 19.0, 20.0))
        }
      }
      "for day 7" - {
        "account a001" in {
          assert(testTransactionDetails(1).head == TransactionDetails(7, "a002", 13.0, 7.0, 36.0, 19.0, 29.0))
        }
        "account a002" in {
          assert(testTransactionDetails(1)(1) == TransactionDetails(7, "a001", 10.0, 5.0, 18.0, 19.0, 26.0))
        }
      }
    }
  }
}
