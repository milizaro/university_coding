package classes

import Enums.SUBJECT_LIST
import scala.util.Random

val RND_t = new Random()

class Teacher(age:Int=0, name:String="", address:String="") extends Human(age, name, address){
  val Rate:Int= new Random().nextInt(4) + 1 // 1-5
  private var subList:List[Subject] = List()
  private val salary:Int = RND_t.between(2500, 7000)

  private def generateSubList(): Unit = {
    var rndSubCount = RND_t.nextInt(SUBJECT_LIST.length - 1) + 1

    var sub = SUBJECT_LIST(RND_t.nextInt(SUBJECT_LIST.length - 1))
    subList = subList :+ sub
    rndSubCount -= 1



    for (i <- 1 to rndSubCount)
      {
        sub = SUBJECT_LIST(RND_t.nextInt(SUBJECT_LIST.length - 1))
        subList = subList :+ sub
      }

      subList = subList.distinct
  }
  
   private def showSubjList():String ={
     var listStr = ""
     subList.foreach(e => listStr += e.Show())
     listStr = listStr.substring(0, listStr.length-2)
     listStr
   }


   def Show():String = {
      var str:String =s"""Teacher
                          |Name: ${name}
                          |Age: ${age}
                          |Address: ${address}
                          |Rate: ${Rate}
                          |Salary: ${salary}
                          |Subjects:${showSubjList()}\n """.stripMargin

      str
    }

  generateSubList()
  }

