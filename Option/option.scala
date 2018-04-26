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
                          2 -> User(2, "Johanna", "Doe", 30, None))
  def findById(id: Int): Option[User] = users.get(id)
  def findAll = users.values
}