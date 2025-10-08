package classes

class Subject(title: String) {
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
  def AddStudent(std:Student): Unit ={
    studentList = studentList :+ std
  }
}