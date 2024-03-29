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

   // Tache 5

   // Méthode removeFirstElement() qui enlève le premier élément de la liste
   def removeFirstElement() : Unit = {
     if(head != null) head = head.next
   }

   // Méthode getLastElement(): Node qui retourne le dernier élément de la liste (faites attention si la liste est vide).
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

   // Méthode addToEnd(element:String) permettant d’ajouter un élément à la fin de la liste. Utiliser pour cette
   //méthode la méthode getLastElement().
   def addToEnd2(element:String) : Unit = {
     var lastNode : Node = getLastElement()
     lastNode.next = new Node(element)
   }

   // tum node larin referans ettigi node degismeli burada --- SILME NOT AL BUNU
   //   YADA SADECE SON IKI NODE UN REFERANSI DEGISMELI
   def addToEnd(element:String) : Unit = {

     var newNode = new Node(element,null)

     if(getLastElement() == null) {
       head = newNode
     } else{
       var newNode = new Node(element,null)
       getLastElement().next = newNode
     }

   }


    // Méthode isPresent(e:String): Boolean qui indique si e est présent dans la liste.
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

   // Tâche 6

   // Méthode findElement(s:String): Node qui retourne le premier nœud correspondant au String donné en argument
   def findElement(s: String) : Node = {
     var pivotNode = head
     var findedNode : Node = null

     while (pivotNode != null){ // Bu sekil tum elemnlari dolasiyorum
       if(pivotNode.item == s)
         findedNode = pivotNode
       pivotNode = pivotNode.next
     }
     findedNode
   }

   // Méthode swapElements(e1:String, e2:String) qui échange le contenu (et uniquement le contenu, pas les
   //nœuds) des deux nœuds correspondant aux String donnés en argument. Utilisez la méthode findElement()
   //ci-dessus.
   def swapElements(e1 : String, e2: String) : Unit = {
     var node1 = findElement(e1)
     var node2 = findElement(e2)

     if(node1 != null && node2 != null) {
       node1.item = e2
       node2.item = e1
     }
   }

    // Méthode removeLastElement() qui enlève le dernier élément de la liste.
    def removeLastElement(): Unit = {
      if (head == null || head.next == null) {
        // Liste boşsa veya tek eleman varsa, head'i null yap.
        head = null
      } else {
        // Listenin sonundan bir önceki düğümü bulana kadar ilerle.
        var lastNode = head
        while (lastNode.next.next != null) {
          lastNode = lastNode.next
        }
        // Son düğümün bağlantısını kes.
        lastNode.next = null
      }
    }

   // Méthode removeElement(e:String) qui enlève le nœud correspondant au String donné en argument.
   // Attention, cette méthode comporte plusieurs difficultés.
  def removeElement(e : String) : Unit = {

   if (head != null && head.item == e) { // silenecek item head ise onun icin
     head = head.next
   } else {

     var prevNode = head  // Önceki düğümü ve mevcut düğümü tutacak değişkenler
     var currentNode = head

     while (currentNode != null && currentNode.item != e) { // Mevcut düğüm null değilse ve item e eşit değilse döngüyü sürdür
       prevNode = currentNode // Önceki düğümü güncelle
       currentNode = currentNode.next // Sonraki düğüme ilerle
     }
     // Eğer silinecek düğüm bulunduysa, bağlantıyı kes
     if (currentNode != null) {
       prevNode.next = currentNode.next
     }
   }
  }

   //Méthode insertAfter(before:String, after:String) qui crée un nouveau nœud et qui l’insère après le
   //nœud correspondant au nœud before, si celui-ci existe
  def insertAfter(before: String, after: String): Unit = {
   if (before != null && after != null) {
     val beforeNode = findElement(before)
     if (beforeNode != null) { // `before` düğümü bulunduysa işlem yap
       val newNode = new Node(after, beforeNode.next)
       beforeNode.next = newNode
     }
   }
 }

 } // End of the LinkedList Class

object LinkedList extends App {

  println("Tests were done, everything is ok")

  /* TEST KODU RUN EDILIRKEN HATALI YERLERIN TESPITI ICIN TESTTEN ALINIP KULLANILAN KODLAR
  val n = new LinkedList()
  n.addToEnd("Alice")
  println(n.toString)
  n.insertAfter("Alice", "Cathy")
  println(s"${n.head.item} and ${n.findElement("Alice").item}")
  println(s"${n.getLastElement().item}")
  n.insertAfter("Alice","Bob")
  println(n.toString)
  println(s"${n.getLastElement().item}")

  n.insertAfter("Cathy", "Dan")
  println(n.toString) // List content (4) : Alice -> Bob -> Cathy -> Dan -> null

  println(n.findElement("Erin"))

  n.insertAfter("Frank",null) // Bunu yapmamali
  println(n.toString)
  println(n.getLastElement().item)

 // n.insertAfter("Erin", "Frank")

   */

  /*
  assertEquals("Cathy", n.getLastElement().item, "'Cathy' MUST be at the end")
  n.insertAfter("Alice", "Bob")
  assertEquals(3, n.getSize(), "size MUST be 3")
  assertEquals("Cathy", n.getLastElement().item, "'Cathy' MUST be at the end")
  n.insertAfter("Cathy", "Dan")
  assertEquals(4, n.getSize(), "size MUST be 4")
  assertEquals("Dan", n.getLastElement().item, "'Dan' MUST be at the end")
  n.insertAfter("Erin", "Frank")
  assertEquals(4, n.getSize(), "size MUST be 4")
  assertEquals("Dan", n.getLastElement().item, "'Dan' MUST be at the end")
  assertFalse(n.isPresent("Erin"), "'Erin' MUST not be in the list")
  assertFalse(n.isPresent("Frank"), "'Frank' MUST not be in the list")
  n.insertAfter("Frank", null)
  assertEquals(4, n.getSize(), "size MUST be 4")
  assertEquals("Dan", n.getLastElement().item, "'Dan' MUST be at the end")
  assertFalse(n.isPresent("Frank"), "'Frank' MUST not be in the list")
  n.insertAfter(null, "Frank")
  assertEquals(4, n.getSize(), "size MUST be 4")
  assertEquals("Dan", n.getLastElement().item, "'Dan' MUST be at the end")
  assertFalse(n.isPresent("Frank"), "'Frank' MUST not be in the list")

   */

  /* Node Class'ini create ettikten sonra test icin kullanilan kisim
  var n3: Node = new Node("Milan")
  var n2: Node = new Node("Paris", n3)
  var n1: Node = new Node("Tokyo", n2)

  println(n3.next) // null
  println(n1.next) // Node@5474c6c -> n2 Node'u
  println(n1.next.item) // Paris
  println(n1.next.next) // Node@4b6995df -> n3 Node'u
  println(n1.next.next.next) // null -> n3 Node'un referans ettigi Node yani null
   */

  /* Testi calistirmadan once metdolari test etmek icin kullandigim kodlar
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

  println(flightList.findElement("Rome")) // Rome
  println(flightList.toString) // List content (5) : Ankara -> Sion -> Paris -> Rome -> Giresun -> null
  println(flightList.findElement("Rome").next.item) // Giresun


  println(flightList.swapElements("Ankara","Rome"))
  println(flightList.toString) // List content (5) : Rome -> Sion -> Paris -> Ankara -> Giresun -> null

  flightList.removeLastElement()
  println(flightList.toString) // List content (4) : Rome -> Sion -> Paris -> Ankara -> null

  // Testing instertAfter Method
  flightList.insertAfter("Sion","New York")
  println(s"Listenin yeni hali = ${flightList.toString}") // Listenin yeni hali = List content (5) : Rome -> Sion -> New York -> Paris -> Ankara -> null

  flightList.removeElement("Sion")
  println(flightList.toString) // List content (3) : Rome -> Paris -> Ankara -> null
  flightList.removeElement("Paris")
  println(flightList.toString) // List content (2) : Rome -> Ankara -> null
  println(flightList.removeElement("Rome"))
  println(flightList.toString) // List content (1) : Ankara -> null


  println(flightList.getLastElement().item)
  flightList.addToEnd("Izmir")
  println(flightList.getLastElement().item)

 */

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
