package classes

class Token(var amount:Double, var Title:String) {

  def GetAmount():Double = amount
  def GetTitle(): String = Title

  def GetInfo():String = s"""${GetTitle()} - ${amount}"""

}
