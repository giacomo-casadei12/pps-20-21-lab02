package u02

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._
import u02.GeometricOperations._
import u02.Optionals.Option._

class exeTest {

  import exe._

  @Test def testParityEven(){
    assertEquals("even", parity(4))
    assertEquals("even", par(4))
  }

  @Test def testParityOdd(){
    assertEquals("odd", parity(5))
  }

  //------------------------------------

  @Test def testNeg(){
    val empty: String => Boolean = _==""
    val notEmpty = neg(empty)
    assertEquals(false, !notEmpty("er"))
    //assertEquals(false, predL("",empty))
  }

  @Test def testNegGeneric(){
    val three: Int => Boolean = _==3
    val notThree = neg(three)
    assertEquals(false, !notThree(6))
  }

  @Test def testCompareDef(): Unit ={
    assertEquals(true, compare(3,4,5))
    assertEquals(true, compareCurry(3)(4)(5))
  }

  @Test def testCompareLit(): Unit ={
    assertEquals(true, compareLiteral(3,4,5))
    assertEquals(true, compareLiteralCurry(3)(4)(5))
  }

  @Test def testCompose(): Unit ={
    assertEquals(9, compose(_-1,_*2)(5))
    val f: Int => Boolean = _==10
    val g: Int => Int = _*2
    assertEquals(true, composeGeneric(f,g)(5))
  }

  //------------------------------------

  @Test def testFibonacci(){
    assertEquals(0, fibonacci(0))
    assertEquals(1, fibonacci(1))
    assertEquals(1, fibonacci(2))
    assertEquals(2, fibonacci(3))
    assertEquals(5, fibonacci(5))
  }

  //------------------------------------

  @Test def testShapesPerimeter(): Unit ={

      assertEquals(20,perimeter(Rectangle(4, 6)))
      assertEquals(8*math.Pi,perimeter(Circle(4)))
      assertEquals(20,perimeter(Square(5)))
  }

  @Test def testShapesArea(): Unit ={

    assertEquals(24,area(Rectangle(4, 6)))
    assertEquals(16*math.Pi,area(Circle(4)))
    assertEquals(25,area(Square(5)))
  }

  //----------------------------------

  @Test def testOptionalFilter(): Unit ={
    assertEquals(None(),filter(Some(3))(_ == 8))
    assertEquals(Some("ciao"),filter(Some("ciao"))(_ <= "hello"))
  }

  @Test def testOptionalMap(): Unit = {
    assertEquals(Some(true), map(Some(4))(_ == 4))
    assertEquals(Some(false), map(Some(4))(_ > 4))
    assertEquals(None(), map(None[Int])(_ == 4))
  }

  @Test def testOptionalMap2(): Unit = {
    assertEquals(Some(7),map2(Some(4), Some(3))(_+_))
    assertEquals(None(),map2(Some(4), None())(_%_))
    assertEquals(Some("hello"),map2(Some("hell"), Some("o"))(_+_))
    assertEquals(Some(7.7),map2(Some(7.7), Some(1.0))(_*_))
  }

}
