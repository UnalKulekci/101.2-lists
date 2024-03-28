object Partie2 extends App {

  var nameList = List[String]("Unal","Paul","Enes","Ahmet")
  println(nameList.mkString(","))

  if(nameList.contains("Paul"))
    println("Paul is here")

  var nameList_2 = nameList.filter( _!="Paul")

  println(s"The class of our new variable is ${nameList_2.getClass} and\n The elements ${nameList_2.mkString(",")}")
  assert(nameList.getClass == nameList_2.getClass)

}
