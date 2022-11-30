object ListCombination extends App {


  // ****** ------ ******
  // problem statement - working with List[Object]
  // ****** ------ ******
  // this will be List[Object] type
  val l = List("hi", "how", "are", List("a", "b"), "you")
  println(l)

  //Now to flatten it, directly its not possible, functions like below wont work.
  //        def func1[T]( x: T ): List[String] = {
  //          x match {
  //            case y: List[String] => y
  //            case y: String => List(y)
  //          }
  //        }
  //or
  //Below method works, but u need to know the object type to be sent
  //        trait Result
  //        case class ListString(values: List[String]) extends Result
  //        case class JustString(values: String) extends Result
  //        def func1( x: Result ): List[String] = {
  //          x match {
  //            case  ListString(y) => y
  //            case JustString(y) => List(y)
  //          }
  //        }

  //we end up using Any in this case.
  def func1( x: Any ): List[String] = {
    x match {
      case  y: List[Any] => y.map(x => x.toString )
      case y: String => List(y)
    }
  }

  val l1 = l.map(x => func1(x))
  println(l1)
  println(l1.flatten)

  // ****** --- END --- ******

}
