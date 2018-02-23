Scala Hello World Demo
=====================

```
sbt test
```

The scala code is using [cats](github.com/typelevel/cats) and works well:


    import cats.implicits._
    import cats.Functor
    import scala.concurrent.ExecutionContext.Implicits.global
    import scala.concurrent.Future
    
    object Hello extends App {
    
      Functor[Future].map(Future("hello"))(_ + "!")
    
    }


But if I add this import:


    import cats.instances.future._


It will report such compilation errors:

    
     Error:(18, 10) could not find implicit value for parameter instance: cats.Functor[scala.concurrent.Future]
       Functor[Future].map(Future("hello"))(_ + "!")


Why it happens, and how can I debug it to find reason? I used all kinds of ways I know, but can't find anything.

The `build.sbt` file is:


    name := "Cats Implicit Functor of Future Compliation Error Demo"
    
    version := "0.1"
    
    organization := "org.my"
    
    scalaVersion := "2.12.4"
    
    sbtVersion := "1.0.4"
    
    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats-core" % "1.0.1"
    )