package classes

class Subject(title: String = "Empty") {
  val Title: String = title
  var studentList: List[Student] = List()
  val Price:Double = RND.between(5, 20)
  private def showStudents():String ={
    var stdStr = ""
    studentList.foreach(s => stdStr += s"""-${s.Name} - ${s.Group}\n ${s.Token.GetInfo()}""".stripMargin)

    stdStr
  }

  def Show():String = s"""
                         |${title}
                         |Students:
                         |${showStudents()}""".stripMargin

  def AddStudent(student:Student): Unit ={
    studentList = studentList :+ student
  }

  def EstimateStudents():Unit={
    studentList.foreach(s => s.Estimation = RND.nextInt(4) + 1)
  }
}