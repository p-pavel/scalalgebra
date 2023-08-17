package scalalgebra.p1

import org.scalacheck.Prop.*
import org.scalacheck.Arbitrary
import org.scalacheck.Test.Parameters
import org.typelevel.discipline.Laws

class SemigroupLaws[T: Semigroup: Arbitrary] extends Laws:
  def all = SimpleRuleSet(
    "semigroup",
    "associative" -> forAll { (a: T, b: T, c: T) =>
      ((a <+> b) <+> c) == (a <+> (b <+> c))
    }
  )
end SemigroupLaws

class MonoidLaws[T: Monoid: Arbitrary] extends SemigroupLaws[T]:
  def monoid = DefaultRuleSet(
    "monoid",
    Some(all),
    "zero" -> forAll {(a: T) => summon[Monoid[T]].empty <+> a == a}
  ) 

class TestSemigroup extends munit.DisciplineSuite:
  override protected def scalaCheckTestParameters: Parameters =
    super.scalaCheckTestParameters.withMinSuccessfulTests(10000)
  checkAll("Int semigroup", MonoidLaws[Int].monoid)
  checkAll("Float semigroup".ignore, SemigroupLaws[Float].all)
  checkAll("String semigroup", SemigroupLaws[String].all)
