package u02

import u02.exe._

object GeometricOperations {

  def perimeter(shape: Shape): Double = shape match {
    case Rectangle(base, height) => (2 * base) + (2 * height)
    case Circle(ray) => 2 * math.Pi * ray
    case Square(side) => 4 * side
    case _ => 0
  }

  def area(shape: Shape): Double = shape match {
    case Rectangle(base, height) => base * height
    case Circle(ray) => math.Pi * ray * ray
    case Square(side) => side * side
    case _ => 0
  }

}
