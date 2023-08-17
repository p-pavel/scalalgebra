package scalalgebra.p1
@main
def start = println("Hello, world!")

trait Semigroup[T]:
  type Carrier = T
  extension (a: Carrier) def <+>(b: Carrier): Carrier 

given intSemigroup: Semigroup[Int] with
  extension (a: Carrier) def <+>(b: Carrier): Carrier = a + b
