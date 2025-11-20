package classes

import scala.util.Random

val RND_t = new Random()

class Teacher(age:Int=0, name:String="", address:String="") extends Human(age, name, address){
  var Subject:Subject = new Subject()
  private val salary:Int = RND_t.between(2500, 7000) //
  
  val Rate:Int= new Random().nextInt(4) + 1 // 1-5
  val Salary = salary
  override val Name: String = name
  
  
  def Show():String = {
    var str:String =s"""Teacher
                        |Name: ${name}
                        |Age: ${age}
                        |Address: ${address}
                        |Rate: ${Rate}
                        |Salary: ${salary}
                        |Subject:${Subject.Show()}\n """.stripMargin

    str
  }
  }

