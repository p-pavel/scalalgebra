package scalalgebra.p1
@main
def start = 
  import Semigroup.given
  println(s"Hello, algebra!: ${42 <+> 10}")

trait Semigroup[T]:
  type Carrier = T
  extension (a: Carrier) def <+>(b: Carrier): Carrier

object Semigroup:
  given forInt: Semigroup[Int] with
    extension (a: Carrier) def <+>(b: Carrier): Carrier = a + b

  given forFloat: Semigroup[Float] with
    extension (a: Float) override def <+>(b: Float): Carrier = a + b
  given forString: Semigroup[String] with
    extension (a: Carrier) override def <+>(b: Carrier): Carrier = a + b

