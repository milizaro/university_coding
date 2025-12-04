package classes

class Token(var amount:Double, var title:String) {

  def GetAmount():Double = amount
  def GetTitle(): String = title

  def GetInfo():String = s"""${GetTitle()} - ${amount}"""

  def +(token:Token): Token = {
    if(title.equals(token.GetTitle()))
     new Token(amount + token.GetAmount(), title)
    else
      throw Exception("Input token isn`t valid")
  }

  def -(token: Token): Token = {
    if (title.equals(token.GetTitle())) {
      if(amount >= token.GetAmount())
        new Token(amount - token.GetAmount(), title)
      else
        throw Exception("Student need additional token amount")
    } else
      throw Exception("Input token isn`t valid")
  }
  
  def >=(token:Token):Boolean={
    if(title.equals(token.title))
      amount >= token.amount
    else 
      throw new Exception("Input Token isn`t valid")
  }
}
