package scalalgebra.p1

import org.typelevel.discipline.Laws
import org.scalacheck.Arbitrary

class SemigroupLaws[T: Semigroup: Arbitrary] extends Laws:
  import org.scalacheck.Prop.*
  def all = SimpleRuleSet(
    "semigroup",
    "associative" -> forAll { (a: T, b: T, c: T) =>
      ((a <+> b) <+> c) == (a <+> (b <+> c))
    }
  )
end SemigroupLaws

class Test extends munit.DisciplineSuite:
  checkAll("Int semigroup", SemigroupLaws[Int].all)
  checkAll("Float semigroup", SemigroupLaws[Float].all)
