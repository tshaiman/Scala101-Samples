import scala.concurrent.{Future,Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

case class User(id:String)
case class DbResponse(state:Int,user:User)
case class Product(prodId:String)

////////////////concurrency //////////////
val productsFuture =  Future {
    getUser()
  }.map{ user =>
    Database.save(user)
  }.map { dbResponse =>
    Products.get(dbResponse.user.id)
  }

  def getUser():User ={
  	Thread.sleep(50);
  	User("tomer")
  }

  object Database {
  	def save(usr:User):DbResponse = {
  		Thread.sleep(50)
  		DbResponse(1,usr)
  	}
  }

  object Products {
  	def get(userId:String) = {
  		Thread.sleep(50)
  		Product("122d45")
  	}
  }

val p = Await.result(productsFuture,1 second)
println(s"The Product id is ${p.prodId}")
