package classes

import Enums.SUBJECT_LIST
import scala.util.Random

val RND = new Random()

class Student(age:Int, name:String, address:String, group:String, token: Token) extends Human(age, name, address){

  private var subList:List[Subject]  = List()
  val Group:String = group
  var Scholarship:Double = 0
  var Estimation:Int = 0

  def GetTokenInfo() = {token.GetInfo()}
  def GetName(): String = name
  def Show():String = {
    val str:String = s"""Student
                        |Name: ${name}
                        |Age: ${age}
                        |Address: ${address}
                        |Group: ${group}
                        |Scholarship: ${Scholarship}
                        |Estimation: ${Estimation}
                        |List of subjects: ${showSubList()}\n""".stripMargin

    str
  }

  def AddSubj(subj:Subject): Unit = subList = subList :+ subj

  private def showSubList():String = {
    var str = ""
    subList.foreach(e => str += e.Title + ", ")
    str = str.substring(0, str.length-2)
    str
  }

  private def generateSubList(): Unit = {
    var rndSubCount = RND.nextInt(SUBJECT_LIST.length-1) + 1
    var sub = SUBJECT_LIST(RND.nextInt(SUBJECT_LIST.length-1))
    subList = subList :+ sub
    rndSubCount -= 1



    for(i <- 1 to rndSubCount)
    {
      sub = SUBJECT_LIST(RND.nextInt(SUBJECT_LIST.length-1))
      subList = subList :+ sub
    }

    subList = subList.distinct
    subList.foreach(s => s.AddStudent(this))
  }

  def GetScholarship(tokenAmount:Double): Unit = {
    token.amount += tokenAmount
    Scholarship = tokenAmount
  }

  def BuyTokens(amount:Double):Unit = {
    token.amount += amount
    Exchange.Token.amount -= amount
  }

  def PayForCourse(subj:Subject):Double={
    var needExtraTokenAmount = 0.0
    if(token.amount >= subj.Price)
      token.amount -= subj.Price
    else{
      needExtraTokenAmount = subj.Price - token.amount
    }

    needExtraTokenAmount
  }
  generateSubList()
}
