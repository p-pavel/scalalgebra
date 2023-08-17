package scalalgebra.p1
@main
def start = 
  import Semigroup.given
  println(s"Hello, algebra!: ${42 <+> 10}")

trait Semigroup[T]:
  type Carrier = T
  extension (a: Carrier) def <+>(b: Carrier): Carrier

trait Monoid[T] extends Semigroup[T]:
  def empty: T

object Semigroup:
  given forInt: Monoid[Int] with
    extension (a: Carrier) def <+>(b: Carrier): Carrier = a + b
    def empty = 0

  given forFloat: Semigroup[Float] with
    extension (a: Float) override def <+>(b: Float): Carrier = a + b
  given forString: Semigroup[String] with
    extension (a: Carrier) override def <+>(b: Carrier): Carrier = a + b

