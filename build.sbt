name := "Double"

version := "1.0"

lazy val `double` = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq( jdbc , anorm , cache , ws , "mysql" % "mysql-connector-java" % "5.1.21","com.nulab-inc" %% "play2-oauth2-provider" % "0.15.1"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  