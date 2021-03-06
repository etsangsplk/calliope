import de.heikoseeberger.sbtheader.{AutomateHeaderPlugin, HeaderPlugin}
import de.heikoseeberger.sbtheader.license.Apache2_0

lazy val commonSettings = Seq(
  organization := "com.rbmhtechnology",
  name := "calliope",
  version := "0.1-SNAPSHOT",
  scalaVersion := "2.12.1"
)

lazy val testSettings = Defaults.itSettings ++ Seq(
  parallelExecution in IntegrationTest := false,
  fork in IntegrationTest := true
)

lazy val headerSettings: Seq[Setting[_]] = {
  val header = Apache2_0("2015 - 2017", "Red Bull Media House GmbH <http://www.redbullmediahouse.com> - all rights reserved.")

  Seq(headers := Map("scala" -> header, "java"  -> header)) ++
    HeaderPlugin.settingsFor(IntegrationTest) ++
    AutomateHeaderPlugin.automateFor(IntegrationTest)
}

lazy val dependencies = Seq(
  "com.typesafe.akka" %% "akka-stream"              % Version.Akka ,
  "com.typesafe.akka" %% "akka-stream-kafka"        % "0.13",
  "org.apache.kafka"  %  "kafka-clients"            % Version.Kafka,
  "org.apache.kafka"  %  "kafka-streams"            % Version.Kafka,

  "org.scalatest"     %% "scalatest"                % "3.0.1"      % "it,test",
  "com.typesafe.akka" %% "akka-stream-testkit"      % Version.Akka % "it,test",
  "com.typesafe.akka" %% "akka-testkit"             % Version.Akka % "it,test",
  "net.manub"         %% "scalatest-embedded-kafka" % "0.11.0"     % "it"
)

lazy val root = (project in file("."))
  .configs(IntegrationTest)
  .settings(commonSettings: _*)
  .settings(testSettings)
  .settings(headerSettings)
  .settings(libraryDependencies ++= dependencies)
  .enablePlugins(HeaderPlugin, AutomateHeaderPlugin)
