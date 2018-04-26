//https://www.scala-exercises.org/fp_in_scala/getting_started_with_functional_programming

def fib(n: Int): Int = {
  @annotation.tailrec
  def loop(n: Int, prev: Int, cur: Int): Int =
    if (n <= 0) prev
    else loop(n - 1 , cur, prev + cur) 
  loop(n, 0, 1)
}


def isSorted[A](as: Array[A], ordering: (A, A) => Boolean): Boolean = {
  @annotation.tailrec
  def go(n: Int): Boolean =
    if (n >= as.length - 1) true
    else if (!ordering(as(n), as(n + 1))) false
    else go(n + 1)

  go(0)
}

////////////Currying 
//http://www.codecommit.com/blog/scala/function-currying-in-scala

def process[A](filter:A=>Boolean)(list:List[A]):List[A] = {
  lazy val recurse = process(filter) _
 
  list match {
    case head::tail => if (filter(head)) {
      head::recurse(tail)
    } else {
      recurse(tail)
    }
 
    case Nil => Nil
  }
}

val even = (a:Int)=> a % 2 == 0
val evenProc = process(even) _
val numbersAsc = 1::2::3::4::5::Nil
val numbersDesc = 5::4::3::2::1::Nil

evenProc(numbersAsc)
evenProc(numbersDesc)
/////////////////////////////////////
//compose
def compose[A, B, C](f: B => C, g: A => B): A => C =
  a => f(g(a))

def f(b: Int): Int = b / 2
def g(a: Int): Int = a + 2

// or use with default scala implementation
//(f _ compose g _) (2)
//val fandThenG = f _ andThen g _

