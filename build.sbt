val scalaLangVersion = "2.11.11"
val jdkVersion = "1.8"
val sparkVersion = "2.1.1"

lazy val root = (project in file(".")).
  settings(
    name := "spark-interview",
    version := "1.0.0",
    scalaVersion := scalaLangVersion,
    javacOptions ++= Seq("-source", jdkVersion, "-target", jdkVersion, "-Xlint"),
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % sparkVersion,
      "org.apache.spark" %% "spark-hive" % sparkVersion,

      // following dependencies are only needed for unit tests
      "org.scalatest" %% "scalatest" % "3.0.1" % "test",
      "com.holdenkarau" %% "spark-testing-base" % s"${sparkVersion}_0.7.4" % "test",
      "org.apache.spark" %% "spark-mllib" % sparkVersion % "test"
    )
  )
