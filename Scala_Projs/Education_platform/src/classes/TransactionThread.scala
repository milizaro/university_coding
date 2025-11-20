package classes
import scala.collection.mutable.Queue
class TransactionThread extends Thread{
  private val buffer: Queue[Student] = Queue()

  private val lock = new Object
  private var token = new Token(5000, "Test")

  override def run():Unit={
    println("Buffer process starts")
    while (buffer.size > 0) {
      val s = buffer.dequeue()
      println(s.Show())
    }
    println("Buffer process ends")
  }

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
    token.amount -= scholarship
    scholarship
  }

  def addStudent(s: Student): Unit = lock.synchronized {
    buffer.enqueue(s)
  }

}
