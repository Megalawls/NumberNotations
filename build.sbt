name := "NumberNotations"

version := "1.0"

scalaVersion := "2.12.2"

scalacOptions += "-P:wartremover:excluded:\\Users\\Megal\\Documents\\QA Consulting\\Academy\\Haskell\\BillionsAndTrillions\\src\\test\\scala"
//Wart remover needs to disable itself for Test, as some of the methods are not covered

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"