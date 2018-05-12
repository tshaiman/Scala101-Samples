trait User {
  def name: String
  def score: Int
}
class FreeUser(val name: String, val score: Int, val upgradeProbability: Double) extends User
class PremiumUser(val name: String, val score: Int) extends User

object FreeUser {
  def unapply(user: FreeUser): Option[(String, Int, Double)] = Some((user.name, user.score, user.upgradeProbability))

}
object PremiumUser {
  def unapply(user: PremiumUser): Option[(String, Int)] = Some((user.name, user.score))
}

case class User1(firstName: String, lastName: String, score: Int)
def advance(xs: List[User1]) = xs match {
  case User1(_, _, score1) :: User1(_, _, score2) :: _ => score1 - score2
  case _ => 0
}

case class MyUser(val name: String, val score: Int, val upgradeProbability: Double) extends User
val user: User = new FreeUser("Daniel", 3000, 0.7d)
val myUser: User = new MyUser("Tomer", 3000, 0.7d)

user match {
  case FreeUser(name, _, p) =>
    if (p > 0.75) name + ", what can we do for you today?" else "Hello " + name
  case PremiumUser(name, _) => "Welcome back, dear " + name
  case MyUser(name, _, p) => if (p > 0.45) name + ", what can we do for you today?" else "Hello " + name
}

val xs = 58 #:: 43 #:: 93 #:: Stream.empty
xs match {
  case first #:: second #:: _ => first - second
  case _ => -1
}

object GivenNames {
  def unapplySeq(name: String): Option[Seq[String]] = {
    val names = name.trim.split(" ")
    if (names.forall(_.isEmpty)) None else Some(names)
  }
}

def greetWithFirstName(name: String) = name match {
  case GivenNames(_, surename, _*) => "Good morning Mr." + surename + "!"
  case _ => "Welcome! Please make sure to fill in your Last - Name!"
}

object Names {
  def unapplySeq(name: String): Option[(String, String, Seq[String])] = {
    val names = name.trim.split(" ")
    if (names.size < 2) None
    else Some((names.last, names.head, names.drop(1).dropRight(1)))
  }
}

def greet(fullName: String) = fullName match {
  case Names(lastName, firstName, rest @ _*) =>
    s"Good morning, $firstName $lastName! . middle length is " +   rest.length
  case _ =>
    "Welcome! Please make sure to fill in your name!"
}