// Listing these out because the versions are specific to the runtime Spark environment
// See https://www.cloudera.com/documentation/enterprise/release-notes/topics/cdh_vd_cdh5_maven_repo_56x.html#concept_970_mcn_yk
val scalaLangVersion = "2.10.4"
val jdkVersion = "1.8"
val sparkVersion = "1.5.0-cdh5.6.0"
val sparkVersionMajor = "1.5.0"
// Match the version of the other json4s libraries in the environment
val json4sVersion = "3.2.10"
// Needs to depend on the same version of kryo as is included in the environment
val kryoSerializersVersion = "0.24"
// Needed for running in YARN; look for version used in Spark
val derbyVersion = "10.11.1.1"

lazy val root = (project in file(".")).
  settings(
    name := "spark-interview",
    version := "1.0.0",
    scalaVersion := scalaLangVersion,
    javacOptions ++= Seq("-source", jdkVersion, "-target", jdkVersion, "-Xlint"),
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % sparkVersion,
      "org.apache.spark" %% "spark-hive" % sparkVersion,
      "org.json4s" %% "json4s-native" % json4sVersion,
      "org.apache.derby" % "derby" % derbyVersion,
      "joda-time" % "joda-time" % "2.9.4",
      "org.joda" % "joda-convert" % "1.8.1",
      "com.databricks" % "spark-csv_2.10" % "1.5.0",
      ("de.javakaffee" % "kryo-serializers" % kryoSerializersVersion).
        // doesn't play nicely with other libraries from CDH
        exclude("com.esotericsoftware.kryo", "kryo"),
      "com.github.scopt" %% "scopt" % "3.5.0",
      "org.scalatest" %% "scalatest" % "3.0.1" % "test",
      ("com.holdenkarau" %% "spark-testing-base" % s"${sparkVersionMajor}_0.6.0" % "test").
        // we're using scalatest; so junit can cause problems for us
        exclude("junit", "junit").
        // prefer to be using the Cloudera versions of these
        excludeAll(ExclusionRule(organization = "org.apache.hadoop"))
    ),
    assemblyJarName in assembly := s"${name.value}-${version.value}.jar",
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    // don't need the scala language libraries since they're on the cluster
    assemblyOption in assembly := (assemblyOption in assembly).value.copy(includeScala = false),
    resolvers +=
      "Cloudera Builds" at "https://repository.cloudera.com/artifactory/cloudera-repos"
  )
