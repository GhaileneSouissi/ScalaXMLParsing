name := "ScalaparsingXml"

version := "0.1"

scalaVersion := "2.11.8"



libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-xml" % "1.1.1",
  "org.scala-lang" % "scala-library" % scalaVersion.value,
  "com.typesafe" % "config" % "1.3.4"
)