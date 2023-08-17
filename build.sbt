ThisBuild / scalaVersion := "3.3.0"
ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-Ykind-projector",
  "-rewrite",
  "-Wunused:all",
)
Global / onChangedBuildSource := ReloadOnSourceChanges

val root = project
  .in(file("."))
  .settings(
    fork := true,
    name := "scalalgebra",
    libraryDependencies +=  "org.typelevel" %% "discipline-munit" % "2.0.0-M3" % Test,
  )