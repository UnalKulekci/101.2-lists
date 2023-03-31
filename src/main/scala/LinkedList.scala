class LinkedList {
  /*
  La classe Node doit contenir deux attributs principaux, item de type String (qui va stocker le nom de la ville) et next (de
  type Node) qui servira à stocker la référence sur l’élément suivant
   */
    class Node(var item: String, var next: Node = null){

    // Instancier qq object de class Node
    var n1: Node = new Node("Tokya") // Ikinci attribut u null olarak tanimladigim icin yazmak zorunda degilim
    var n2: Node = new Node("Paris")
    var n3: Node = new Node("Milan")

    n1.next = n2
    n2.next = n3
    n3.next = null
  }
}