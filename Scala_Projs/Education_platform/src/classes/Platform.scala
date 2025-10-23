package classes

class Platform(teacherList: List[Teacher]) {
private val _teacherList = teacherList
private var token = new Token(5000, "Test")

  def CalculateScholarship(grade: Int, subjPrice: Double): Double = {
    var scholarship: Double = 0
    grade match {
      case 5 => scholarship = 1.1 * subjPrice
      case 4 => scholarship = 1 * subjPrice
      case 3 => scholarship = 0.9 * subjPrice
      case 2 => scholarship = 0.8 * subjPrice
      case 1 => scholarship = 0.7 * subjPrice
      case _ => scholarship = 0
    }
    token.Amount -= scholarship
    scholarship
  }
  def IsTimeToActivateSubject(subject: Subject, month:Int):Unit = {
    if(subject.GetStartMonth() >= month && month <= subject.GetEndMonth()){
      if(!subject.IsActive()){
        subject.Activate()
        subject.studentList.foreach(s => {
          val needExtraTokenAmount = s.PayForCourse(subject)
          if(needExtraTokenAmount > 0){
            s.BuyTokens(needExtraTokenAmount)
            s.PayForCourse(subject)
          }
        })
      }
    }else
      subject.Deactivate()
  }
  def TransferScholarship():Unit = {
    _teacherList.foreach(t => {
      if(t.Subject.IsActive()){
        t.Subject.EstimateStudents()
        t.Subject.studentList.foreach(s => {
          s.GetScholarship(CalculateScholarship(s.Estimation, t.Subject.Price))
          })
      }
    })
  }
}
