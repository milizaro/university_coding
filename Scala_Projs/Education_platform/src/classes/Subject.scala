package classes

class Subject(title: String = "Empty") {
  val Title: String = title
  var studentList: List[Student] = List()
  
  private def showStudents():String ={
    var stdStr = ""
    studentList.foreach(s => stdStr += s"""-${s.Name} - ${s.Group}\n""".stripMargin)

    stdStr
  }

  def Show():String = {
    var str =
      s"""
         |${title}
         |Students:
         |${showStudents()}""".stripMargin


    str
  }
  def AddStudent(student:Student): Unit ={
    studentList = studentList :+ student
  }

}