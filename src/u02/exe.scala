package u02

object exe{

  def parity(value: Int): String = value match {
    case value if value%2==0 => "even"
    case _ => "odd"
  }

  val par: Int => String = {
    case x if x % 2 == 0 => "even"
    case _ => "odd"
  }

  //-----------

  def neg[A](pred: A => Boolean): A => Boolean = (x: A) => !pred(x)

  val negLiteral: (String=>Boolean) => String => Boolean = f => s => !f(s)

  def compare(x: Int, y:Int, z:Int): Boolean = x<=y && y<=z

  def compareCurry(x:Int)(y:Int)(z:Int): Boolean = x<=y && y<=z

  val compareLiteral = (x:Int, y:Int, z:Int) => x <= y && y <= z

  val compareLiteralCurry: Int => Int => Int => Boolean = x => y => z => x<=y && y<=z

  def compose(f: Int=> Int, g: Int => Int): Int => Int = (x: Int) => f(g(x))

  def composeGeneric[A,B,C](f: B=> C, g: A => B): A => C = (x: A) => f(g(x))

  //----------------------------------

  def fibonacci(n: Int): Int = n match {
        case 0 => 0
        case 1 => 1
        case _ => fibonacci(n-2) + fibonacci(n-1)
      }

  //------------------------------------

  sealed trait Shape
  case class Rectangle(base: Double, height: Double) extends Shape
  case class Circle(ray: Double) extends Shape
  case class Square(side: Double) extends Shape

}
