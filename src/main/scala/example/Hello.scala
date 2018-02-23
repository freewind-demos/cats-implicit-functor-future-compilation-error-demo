package example
package platform.strategies

//import cats.implicits._
import cats.Functor
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

// If uncomment the following line, it will report compilation error:
// Error:(14, 10) could not find implicit value for parameter instance: cats.Functor[scala.concurrent.Future]
// Functor[Future].map(Future("hello"))(_ + "!")
// why and how to debug it?

import cats.instances.future._

object Hello extends App {

  Functor[Future].map(Future("hello"))(_ + "!")

}
