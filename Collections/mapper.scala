val record = Map("amenity" -> "restaurant", "cuisine" -> "chinese", "name" -> "Golden Palace")
val record2 = Map("amenity" -> 1, "cuisine" -> "chinese", "name" -> true)
val l = List("amenity","cuisine" , "non")
val l2 = List("amenity","cuisine" , "non","name","Name","nooo")

l flatMap (record get _)
l2 flatMap (record2 get _)

