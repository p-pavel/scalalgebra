package scalalgebra.p1
@main
def start = println("Hello, world!")

trait Semigroup[T]:
  type Carrier = T
  extension (a: Carrier) def <+>(b: Carrier): Carrier

object Semigroup:
  given foeInt: Semigroup[Int] with
    extension (a: Carrier) def <+>(b: Carrier): Carrier = a + b

  given forFloat: Semigroup[Float] with
    extension (a: Float) override def <+>(b: Float): Carrier = a + b
