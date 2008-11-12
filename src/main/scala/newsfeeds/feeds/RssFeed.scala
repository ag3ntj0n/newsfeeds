package newsfeeds.feeds
import scala.xml.{Elem, XML, Node} 
import java.lang.IllegalArgumentException

class RssFeed (var feedpath:String) extends Feed{
  
  private val feed:Elem = XML.load(feedpath)
 
  if (feed.label.toLowerCase() != "rss"){
    throw new IllegalArgumentException(feedpath + " is not a valid rss file")
  }
  
  override val name =  feed \ "channel" \ "title"
  override val items = feed \ "channel" \\ "item"
  override val elements = items.map( x => new RssFeedItem(x) )  //Seq.empty
  
}

class RssFeedItem( n:Node ) extends TItem{
  val title = ( n \ "title").text
  val url = ( n \ "link").text
  
  val contents = ( n \ "description" ).text
  val author = ( n \ "creator").text
  val date = ( n \ "pubDate" ).text
}