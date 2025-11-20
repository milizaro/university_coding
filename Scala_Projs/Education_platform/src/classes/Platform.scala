package classes
import scala.collection.mutable.Queue
import Enums.STUDENT_LIST

class Platform(teacherList: List[Teacher], transactionThread: TransactionThread) {
private val _teacherList = teacherList 
  
  private def isTimeToActivateSubject(subject: Subject, month:Int):Unit = {
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

  def TransferScholarship(month:Int):Unit = {
    _teacherList.foreach(t => {
      isTimeToActivateSubject(t.Subject, month)
      if(t.Subject.IsActive()){
        t.Subject.EstimateStudents()
        t.Subject.studentList.foreach(s => {
          transactionThread.addStudent(s)
          })        
      }
    })
    transactionThread.run()   

  }
}
