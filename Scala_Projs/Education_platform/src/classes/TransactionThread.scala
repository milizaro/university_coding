package classes
import scala.collection.mutable
import scala.collection.mutable.Queue
class TransactionThread extends Thread{
  private val buffer: Queue[Map[Student, Subject]] = Queue()

  private val lock = new Object

  override def run():Unit={
    println("Buffer process starts")
    while (buffer.size > 0) {
      val studentMap = buffer.dequeue()
      studentMap.foreach( s_subj => {
        print(s"BEFORE______${s_subj._2.Title}_____")
        s_subj._1.GetScholarship(
                      CalculateScholarship(s_subj._1.EstimationMap(s_subj._2), s_subj._2.Price.GetAmount()))
      })

    }
    println("Buffer process ends")
  }

  def CalculateScholarship(grade: Int, subjPrice: Double): Token = {
    var scholarshipAmount: Double = 0
    grade match {
      case 5 => scholarshipAmount = 1.1 * subjPrice
      case 4 => scholarshipAmount = 1 * subjPrice
      case 3 => scholarshipAmount = 0.9 * subjPrice
      case 2 => scholarshipAmount = 0.8 * subjPrice
      case 1 => scholarshipAmount = 0.7 * subjPrice
      case _ => scholarshipAmount = 0
    }
    Exchange.BuyTokens(new Token(scholarshipAmount, "Test"))
  }

  def addStudentAndSubject(s: Student, subj:Subject): Unit = lock.synchronized {
    buffer += Map(s -> subj)
  }

}
