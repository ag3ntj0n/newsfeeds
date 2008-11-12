package newsfeeds.aggregate

import newsfeeds.feeds.Feed
import scala.xml.{Elem, XML, Node, NodeSeq}
import scala.collection.mutable.Queue
import newsfeeds.feeds.TItem

class OpmlFeed(var feedpath:String) extends Feed {
  
  private val feed:Elem =  XML.load(feedpath)
  override val name =  (feed \ "head" \ "title")
  
  val items =  (feed \\ "outline").filter( k => (k \ "@xmlUrl").length == 1 )
  override val articles = items.map( x => new OpmlItem(x) )
}

class OpmlItem( n:Node ) extends TItem{
  val title = (n \ "@text").text
  val url = ( n \ "@xmlUrl" ).text
 
  val contents = null
  val author = null
  val date = null
}