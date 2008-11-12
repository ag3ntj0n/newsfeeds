package newsfeeds.aggregate

import newsfeeds.feeds.Feed
import scala.xml.{Elem, XML, Node, NodeSeq}
import scala.collection.mutable.Queue
import newsfeeds.feeds.TItem

class OpmlFeed(var feedpath:String) extends Feed {
  
  private val feed:Elem =  XML.load(feedpath)
  override val name =  (feed \ "head" \ "title")
  
  //var itms:NodeSeq =   new Queue[Elem]
  //(feed \\ "outline").foreach( entry => if ((entry \ "@xmlUrl").length  == 1 ) {itms = itms ++ entry} )
  //val i = (feed \\ "outline").filter( k => (k \ "@xmlUrl").length == 1 )
  //if ( itms== i) {println("!!!!!!!!!!!!!!!!!!!!")} else {println("doh")}
  
  val items =  (feed \\ "outline").filter( k => (k \ "@xmlUrl").length == 1 )// itms.asInstanceOf[NodeSeq] //(feed \\ "outline").foreach () //where outline has xmlUrl
  override val articles = items.map( x => new OpmlItem(x) )//Seq.empty
}

class OpmlItem( n:Node ) extends TItem{
  val title = (n \ "@text").text
  val url = ( n \ "@xmlUrl" ).text
 
  val contents = null
  val author = null
  val date = null
}