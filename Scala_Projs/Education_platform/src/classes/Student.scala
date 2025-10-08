package classes

import Enums.SUBJECT_LIST
import scala.util.Random

val RND = new Random()

class Student(age:Int, name:String, address:String, group:String) extends Human(age, name, address){

  override val Name: String = name
  val Group:String = group
  private var subList:List[Subject]  = List()

  def Show():String = {
    val str:String = s"""Student
                        |Name: ${name}
                        |Age: ${age}
                        |Address: ${address}
                        |Group: ${group}
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
    sub.AddStudent(this)
    subList = subList :+ sub
    rndSubCount -= 1



    for(i <- 1 to rndSubCount)
    {
      sub = SUBJECT_LIST(RND.nextInt(SUBJECT_LIST.length-1))
      subList = subList :+ sub
    }

    subList = subList.distinct
  }

  generateSubList()
}
