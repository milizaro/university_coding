package classes

import Enums.SUBJECT_LIST
import scala.collection.mutable
import scala.util.Random

val RND = new Random()

class Student(age:Int, name:String, address:String, group:String, var token: Token) extends Human(age, name, address){
  var EstimationMap:mutable.Map[Subject, Int]= mutable.Map()
  var Scholarship: Double = 0
  val Group:String = group

  def GetTokenInfo() = {token.GetInfo()}
  def GetName(): String = name
  def Show():String = {
    val str:String = s"""Student
                        |Name: ${name}
                        |Age: ${age}
                        |Scholarship: ${Scholarship}
                        |Address: ${address}
                        |Group: ${group}
                        |Token: ${token.GetInfo()}
                        |List of subjects: ${showSubList()}\n""".stripMargin

    str
  }

  private def showSubList():String = {
    var str = ""
    EstimationMap.foreach(subEst => {
     str += s"${subEst._1.Title} - ${subEst._2}\n"
    })
    str
  }

  private def generateSubList(): Unit = {

    var subList:List[Subject]  = List()

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

    subList.foreach(s => {
      s.AddStudent(this)
      EstimationMap +=(s, 0)
    })
  }

  def GetScholarship(Token: Token): Unit = {
    print(s"${name} === ${Scholarship} === ${token.amount}:::::::")
    token += Token
    Scholarship = Token.amount
    println(s"AFTER_____${name} === ${Scholarship} === ${token.amount}")
  }

  def BuyTokens(Token:Token):Unit = {
    token += Exchange.BuyTokens(Token)

  }

  def PayForCourse(subj:Subject):Token={
    var needExtraTokenAmount = new Token(0, "");
    if(token >= subj.Price) {
      token -= subj.Price
      Exchange.PayForCourse(subj.Price)
    } else{
      needExtraTokenAmount = subj.Price - token
    }

    needExtraTokenAmount
  }
  generateSubList()
}
