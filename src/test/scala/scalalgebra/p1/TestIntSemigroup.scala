package scalalgebra.p1

import org.typelevel.discipline.Laws
import org.scalacheck.Arbitrary
import org.scalacheck.Test.Parameters

class SemigroupLaws[T: Semigroup: Arbitrary] extends Laws:
  import org.scalacheck.Prop.*
  def all = SimpleRuleSet(
    "semigroup",
    "associative" -> forAll { (a: T, b: T, c: T) =>
      ((a <+> b) <+> c) == (a <+> (b <+> c))
    }
  )
end SemigroupLaws

class TestSemigroup extends munit.DisciplineSuite:
  override protected def scalaCheckTestParameters: Parameters =
    super.scalaCheckTestParameters.withMinSuccessfulTests(10000)
  checkAll("Int semigroup", SemigroupLaws[Int].all)
  checkAll("Float semigroup".ignore, SemigroupLaws[Float].all)
  checkAll("String semigroup", SemigroupLaws[String].all)
