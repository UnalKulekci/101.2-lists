/*
 La classe Node doit contenir deux attributs principaux, item de type String (qui va stocker le nom de la ville) et next (de
 type Node) qui servira à stocker la référence sur l’élément suivant
  */
class Node (var item: String, var next: Node){

  /*
  Redéfinissez le constructeur pour qu’il accepte directement comme paramètre un String contenant la donnée à
 stocker ainsi qu’une référence sur l’élément suivant de la liste.
   */
  def this(item: String)={
    this(item,null)
  }
}

object Vol extends App {

  var n3 : Node = new Node("Milan")
  var n2 : Node = new Node("Paris",n3)
  var n1 : Node = new Node("Tokyo",n2)


}
