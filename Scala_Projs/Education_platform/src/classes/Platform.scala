package classes

class Platform(teacherList: List[Teacher]) {
private val _teacherList = teacherList


  def CalculateScholarship(grade: Int, priceCourse: Double): Double = {
    var scholarship: Double = 0
    grade match {
      case 5 => scholarship = 1.1 * priceCourse
      case 4 => scholarship = 1 * priceCourse
      case 3 => scholarship = 0.9 * priceCourse
      case 2 => scholarship = 0.8 * priceCourse
      case 1 => scholarship = 0.7 * priceCourse
      case _ => scholarship = 0
    }
    scholarship
  }

  def TransferScholarship():Unit = {
    _teacherList.foreach(t => {
      t.Subject.studentList.foreach(s => {s.Scholarship = CalculateScholarship(s.Estimation, t.Subject.Price)})
    })
  }
}
