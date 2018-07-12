////From the Neophyts Guide chapter 5
//https://danielwestheide.com/blog/2012/12/19/the-neophytes-guide-to-scala-part-5-the-option-type.html



val absentGreeting: Option[String] = Option(null) // absentGreeting will be None
val presentGreeting: Option[String] = Option("Hello!") // presentGreeting will be Some("Hello!")

case class User(
  id: Int,
  firstName: String,
  lastName: String,
  age: Int,
  gender: Option[String])

object UserRepository {
  private val users = Map(1 -> User(1, "John", "Doe", 32, Some("male")),
                          2 -> User(2, "Johanna", "Doe", 30, None),
                          5 -> User(5, "Tamar", "Doe", 30, Some("female")),
                          12 -> User(12, "Dana", "Doe", 30, Some("female"))
                      )

  def findById(id: Int): Option[User] = users.get(id)
  def findAll = users.values
}

println("foreach demo")
//foreah works on Option !
UserRepository.findById(3).foreach(user => println(user.firstName))
val firstName3 = UserRepository.findById(3).map(_.firstName)
val age = UserRepository.findById(2).map(_.age) 

//bad
println("map vrs flatMap")
val gender = UserRepository.findById(2).map(_.gender) 
//good
val gender1 = UserRepository.findById(1).flatMap(_.gender) 
val gender2 = UserRepository.findById(2).flatMap(_.gender) 
val gender3 = UserRepository.findById(3).flatMap(_.gender) 

println("user ToUpperCase")
///Exercise : Perform to Upper 
val names: List[Option[String]] = List(Some("Johanna"), None, Some("Daniel"))

val uppers = names.flatMap(_.map(_.toUpperCase)) // or names.flatten.map(_.toUpperCase)

println("For Comprehension")
///For Comprehension
for {
	user <- UserRepository.findById(1)
	gender <- user.gender 
} yield gender

val gen = for {
	user <- UserRepository.findAll
	gender <- user.gender 
} yield gender



