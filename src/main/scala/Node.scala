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
       text += s"${currentNode.item} -> "
       currentNode = currentNode.next
     }
     text + "null"
   }

   def removeFirstElement() : Unit = {
     if(head != null) head = head.next
   }

   def getLastElement() : Node = {

     var size : Int = getSize() // Size kadar liste'deki next'lemek icin once bunu aliyorum
     var lastNode : Node = head

     if(size == 0) {
       return null
     } else {
       for(i <- 1 to (size-1)){
         lastNode = lastNode.next
       }
        return lastNode
     }
   }

   def addToEnd(element:String) : Unit = {
     var lastNode : Node = getLastElement()
     lastNode.next = new Node(element)
   }

   def isPresent(e: String): Boolean = {
     var checkNode: Node = head
     var size: Int = getSize()
     var isHere = false

     for(i <- 1 to (size)){
       if(checkNode.item == e) {
         isHere = true
       }
       checkNode = checkNode.next
     }
     return isHere
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
  println(flightList.getLastElement()) // List is empty and null
  flightList.addToStart("Rome")
  println(flightList)
  flightList.addToStart("Paris")
  println(flightList)
  flightList.addToStart("Tokyo")
  println(flightList)

  flightList.removeFirstElement()
  println(flightList.toString) // Paris -> Rome -> null

  flightList.addToStart("Sion")
  flightList.addToStart("Ankara")
  println(flightList.toString)
  println(s"Last element = ${flightList.getLastElement()} and; \t\nThe item of last element = ${flightList.getLastElement().item}")
  /*
  Last element = Node@17d99928 and;
  The item of last element = Rome
   */

  flightList.addToEnd("Giresun")
  println(s"Last element = ${flightList.getLastElement()} and; \t\nThe item of last element = ${flightList.getLastElement().item}")
  /*
  Last element = Node@3834d63f and;
  The item of last element = Giresun
   */

  println(flightList.isPresent("Giresun"))
  println(flightList.isPresent("Amsterdam"))


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
