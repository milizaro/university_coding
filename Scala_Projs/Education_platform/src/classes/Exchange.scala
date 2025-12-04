package classes

object Exchange {
  private var token: Token = new Token(200000, "Test")

  def BuyTokens(Token: Token): Token = {
    token -= Token
    Token
  }

  def PayForCourse(Token: Token): Unit = {
    token += Token
  }

}