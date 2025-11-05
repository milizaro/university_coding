package classes

class Subject(title: String = "Empty") {
  val Title: String = title
  var studentList: List[Student] = List()
  val Price:Double = RND.between(5, 20)
  private var startMonth:Int = 0
  private var endMonth:Int = 0
  private var isActive: Boolean = false

  def IsActive(): Boolean = {
    isActive
  }

  def GetStartMonth():Int = startMonth
  def GetEndMonth():Int = endMonth
  def Activate():Unit = isActive = true
  def Deactivate():Unit = isActive = false

  private def setSubjectDuration():Unit ={
    val num1 = RND.nextInt(3)+1 // 1-4
    val num2 = RND.nextInt(5)+1 // 1-6

    if(num1 > num2){
      startMonth = num2
      endMonth = num1
    }else if(num1 == num2){
      startMonth = num1
      endMonth = num2 + RND.nextInt(2)+1 // num2 + (1-3)
    }else{
      startMonth = num1
      endMonth = num2
    }
  }

  private def showStudents():String ={
    var stdStr = ""
    studentList.foreach(s => stdStr += s"""-${s.GetName()}-Estimation ${s.Estimation} - Scholarship ${s.Scholarship} - ${s.Group}\n ${s.GetTokenInfo()}\n""".stripMargin)

    stdStr
  }

  def Show():String = s"""
                         |${title}
                         |StartMonth: ${startMonth}
                         |EndMonth: ${endMonth}
                         |Price: ${Price}
                         |Students:
                         |${showStudents()}""".stripMargin

  def AddStudent(student:Student): Unit ={
    studentList = studentList :+ student
  }

  def EstimateStudents():Unit={
    studentList.foreach(s => s.Estimation = RND.nextInt(4) + 1)
  }

  setSubjectDuration()
}