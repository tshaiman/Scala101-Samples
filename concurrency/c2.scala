import scala.concurrent.{Future,Await,Promise}
import scala.util.{Failure, Success}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps
import scala.util.Random

//https://docs.scala-lang.org/overviews/core/futures.html

def CloudCompute(value:Int):Future[Int] = Future {
	Thread.sleep(Random.nextInt(500))
	//throw new Exception("this is not right")
	value
}

val f1 = CloudCompute(42)

f1 onComplete {
	case Success(x) => println("wow" + x)
	case Failure(e) => println("an Error has occured " + e)
}


 val result1 = CloudCompute(10)
    val result2 = CloudCompute(20)
    val result3 = CloudCompute(30)

    println("before for-comprehension")
    val result = for {
        r1 <- result1
        r2 <- result2
        r3 <- result3
    } yield (r1 + r2 + r3)


println("The result is " + Await.result(result1,1 second))


//////////////////Promise////////////////
val p = Promise[Int]()
val f = p.future

def produceSomething():Int = {
	Thread.sleep(50)
	43
}

def continueDoingSomethingUnrelated() = println("unrelated work")
def startDoingSomething() = println("starting work")
def doSomethingWithResult(res:Int) = println(s"The give result is $res")

val producer = Future {
  val r = produceSomething()
  p success r
  continueDoingSomethingUnrelated()
}

val consumer = Future {
  startDoingSomething()
  f onSuccess {
    case r => doSomethingWithResult(r)
  }
}

