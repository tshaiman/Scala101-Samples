abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr

val un = UnOp("abs" ,Number(5))

object NumberChecker {
	def unapply(ex:Number):Boolean = {
	if(ex.num > 4) true else false
	}
	
}

object VarChecker {
	def unapply(ex:Var):Boolean = {
		if(ex.name.startsWith("to")) true else false
	}
}


def matchExpr(expr: Expr) =
	expr match {
		case UnOp("abs", e @ UnOp("abs", _)) => e
		case nb @ NumberChecker()	=> println("its a number " + nb.num)
		case vr @ VarChecker() => println("it is a var " + vr.name)
		case _ => "huh?"
}