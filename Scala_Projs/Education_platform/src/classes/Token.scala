package classes

class Token(var amount:Double, var Title:String) {

  def GetAmount():Double = amount
  def GetTitle(): String = Title

  def GetInfo():String = s"""${GetTitle()} - ${amount}"""

 def +(token:Token):Token = {
      if(GetTitle() == token.Title)
        new Token(amount + token.amount, GetTitle())
      else
        throw new IllegalArgumentException("Not match token symb!")
  }

  def -(token: Token): Token = {
    if (GetTitle() == token.Title && amount >= token.amount)
      new Token(amount - token.amount, GetTitle())
    else
      throw new IllegalArgumentException("Not match token symb!")
  }

  def >(token: Token): Boolean = {
    if (GetTitle() == token.Title)
      this.amount > token.amount
    else
      throw new IllegalArgumentException("Tokens have different symbols!")
  }



  def <(token: Token): Boolean = {
    if (GetTitle() == token.Title)
      this.amount < token.amount
    else
      throw new IllegalArgumentException("Tokens have different symbols!")
  }
}
