import CodingAssignment.{Transaction, totalTransactionAmountByDay}
import org.scalatest.freespec.AnyFreeSpec

class CodingAssignmentSpec extends AnyFreeSpec {

  val testData: List[Transaction] = List(
    Transaction(transactionId = "t001", accountId = "a001", transactionDay = 1, category = "AA", transactionAmount = 1.0),
    Transaction(transactionId = "t002", accountId = "a002", transactionDay = 1, category = "AA", transactionAmount = 2.0),
    Transaction(transactionId = "t003", accountId = "a001", transactionDay = 1, category = "AA", transactionAmount = 3.0),
    Transaction(transactionId = "t004", accountId = "a002", transactionDay = 1, category = "AA", transactionAmount = 5.0),
    Transaction(transactionId = "t005", accountId = "a001", transactionDay = 1, category = "AA", transactionAmount = 10.0),
    Transaction(transactionId = "t006", accountId = "a002", transactionDay = 2, category = "AA", transactionAmount = 2.0),
    Transaction(transactionId = "t007", accountId = "a001", transactionDay = 2, category = "AA", transactionAmount = 4.0),
    Transaction(transactionId = "t008", accountId = "a002", transactionDay = 2, category = "AA", transactionAmount = 6.0),
    Transaction(transactionId = "t009", accountId = "a001", transactionDay = 2, category = "AA", transactionAmount = 8.0),
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
}
