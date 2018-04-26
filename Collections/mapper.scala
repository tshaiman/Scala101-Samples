val record = Map("amenity" -> "restaurant", "cuisine" -> "chinese", "name" -> "Golden Palace")
val record2 = Map("amenity" -> 1, "cuisine" -> "chinese", "name" -> true)
val l = List("amenity","cuisine" , "non")
val l2 = List("amenity","cuisine" , "non","name","Name","nooo")

l flatMap (record get _)
l2 flatMap (record2 get _)

import scala.collection.mutable

class BaseRecord(impressionId:String,url:String,counter1:Int,couner2:Int) {
	var map:mutable.Map[String,Any] = mutable.Map[String,Any]()

	def Add(name:String,value:Any) = {
		map += (name->value)
	}

	def Print() = {
		map.values foreach println
	}

	def Get(name:String) = {
		map get name
	}
}

val b:BaseRecord = new BaseRecord("xxxADART","http://wwww.cnn.com",1,2)
b.Add("tomer",1)
b.Add("11","12")
b.Add("13",4.5d)
b.Add("14",true)
b.Print()

