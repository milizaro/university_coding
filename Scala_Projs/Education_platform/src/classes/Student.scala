package classes

import scala.collection.mutable.Map
import Enums.SUBJECT_LIST

import scala.collection.mutable
import scala.util.Random

val RND = new Random()

class Student(age:Int, name:String, address:String, group:String, token: Token) extends Human(age, name, address){
  var EstimationMap:mutable.Map[Subject, Int]= mutable.Map()
  var Scholarship: Double = 0
  val Group:String = group

  def GetTokenInfo() = {token.GetInfo()}
  def GetName(): String = name
  def Show():String = {
    val str:String = s"""Student
                        |Name: ${name}
                        |Age: ${age}
                        |Address: ${address}
                        |Group: ${group}
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
