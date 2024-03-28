class Node(var item: String, var next: Node){
  def this(item: String)= {
    this(item,null) // Burada item girilen string degerine , next ise null'a esit olacak.
  }
} // End of the Node Class

 class LinkedList(var head : Node = null) {
  def addToStart(s: String): Unit = { // Burdaki s yeni node'un ismi yeni item
    head = new Node(s,head) // head artik onceden head olani referans edecek.
  }

  def getSize(): Int = {
    var currentNode = head
    var countSize = 0

    while (currentNode != null) {
      countSize += 1
      currentNode = currentNode.next
    }
    countSize
  }

   override def toString : String = {
     var text : String = s"List content (${getSize()}) : "
     var currentNode = head

     while(currentNode != null) {
       text += s"${currentNode.item} ->"
       currentNode = currentNode.next
     }
     text + "null"
   }

} // End of the LinkedList Class

object LinkedList extends App {

  var n3: Node = new Node("Milan")
  var n2: Node = new Node("Paris", n3)
  var n1: Node = new Node("Tokyo", n2)
  /*
  println(n3.next) // null
  println(n1.next) // Node@5474c6c -> n2 Node'u
  println(n1.next.item) // Paris
  println(n1.next.next) // Node@4b6995df -> n3 Node'u
  println(n1.next.next.next) // null -> n3 Node'un referans ettigi Node yani null
   */


  var flightList: LinkedList = new LinkedList()
  println(flightList)
  flightList.addToStart("Rome")
  println(flightList)
  flightList.addToStart("Paris")
  println(flightList)
  flightList.addToStart("Tokyo")
  println(flightList)

  /* Kodlama asamasinda methodlarin calisip calismadigini test etmek maksatli yazdigim satirlar
  println(flightList.head)
  flightList.addToStart("Tokyo")
  println(flightList.head.item)
  flightList.addToStart("Ankara")
  flightList.addToStart("Istanbul")
  println(flightList.addToStart("Sion"))
  println(flightList.head.item)
  println(flightList.getSize())
  println(flightList.toString)

   */


}
