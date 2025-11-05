package classes

class Token(var amount:Double, var Title:String) {

  def Amount():Double = amount
  private var title: String = Title

  def GetInfo():String = s"""${title} - ${amount}"""

  def +(token:Token):Token = {
      if(title == token.Title)
        new Token(amount + token.amount, title)
      else
        throw new IllegalArgumentException("Not match token symb!")
  }

  def -(token: Token): Token = {
    if (title == token.Title && amount >= token.amount)
      new Token(amount - token.amount, title)
    else
      throw new IllegalArgumentException("Not match token symb!")
  }

  def >(token: Token): Boolean = {
    if (title == token.Title)
      this.amount > token.amount
    else
      throw new IllegalArgumentException("Tokens have different symbols!")
  }



  def <(token: Token): Boolean = {
    if (title == token.Title)
      this.amount < token.amount
    else
      throw new IllegalArgumentException("Tokens have different symbols!")
  }
}
