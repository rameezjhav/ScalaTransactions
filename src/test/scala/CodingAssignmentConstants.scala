import CodingAssignment.Transaction

object CodingAssignmentConstants {

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

  val testDataExtended: List[Transaction] = testData:::List(
    Transaction(transactionId = "t016", accountId = "a002", transactionDay = 4, category = "AA", transactionAmount = 3.0),
    Transaction(transactionId = "t017", accountId = "a001", transactionDay = 4, category = "CC", transactionAmount = 2.0),
    Transaction(transactionId = "t018", accountId = "a002", transactionDay = 4, category = "FF", transactionAmount = 5.0),
    Transaction(transactionId = "t019", accountId = "a001", transactionDay = 4, category = "AA", transactionAmount = 7.0),
    Transaction(transactionId = "t020", accountId = "a002", transactionDay = 4, category = "CC", transactionAmount = 10.0),
    Transaction(transactionId = "t021", accountId = "a001", transactionDay = 5, category = "FF", transactionAmount = 4.0),
    Transaction(transactionId = "t022", accountId = "a002", transactionDay = 5, category = "AA", transactionAmount = 3.0),
    Transaction(transactionId = "t023", accountId = "a001", transactionDay = 5, category = "CC", transactionAmount = 6.0),
    Transaction(transactionId = "t024", accountId = "a002", transactionDay = 5, category = "FF", transactionAmount = 8.0),
    Transaction(transactionId = "t025", accountId = "a001", transactionDay = 5, category = "AA", transactionAmount = 11.0),
    Transaction(transactionId = "t026", accountId = "a002", transactionDay = 6, category = "CC", transactionAmount = 2.0),
    Transaction(transactionId = "t027", accountId = "a001", transactionDay = 6, category = "FF", transactionAmount = 3.0),
    Transaction(transactionId = "t028", accountId = "a002", transactionDay = 6, category = "AA", transactionAmount = 2.0),
    Transaction(transactionId = "t029", accountId = "a001", transactionDay = 6, category = "CC", transactionAmount = 2.0),
    Transaction(transactionId = "t030", accountId = "a002", transactionDay = 6, category = "FF", transactionAmount = 3.0),
    Transaction(transactionId = "t031", accountId = "a001", transactionDay = 7, category = "AA", transactionAmount = 17.0),
    Transaction(transactionId = "t032", accountId = "a002", transactionDay = 7, category = "CC", transactionAmount = 15.0),
    Transaction(transactionId = "t033", accountId = "a001", transactionDay = 7, category = "FF", transactionAmount = 14.0),
    Transaction(transactionId = "t034", accountId = "a002", transactionDay = 7, category = "AA", transactionAmount = 24.0),
    Transaction(transactionId = "t035", accountId = "a001", transactionDay = 7, category = "CC", transactionAmount = 13.0)
  )

}
