package newsfeeds.feeds

import scala.xml.{Elem, XML, Node}
import scala.collection.immutable.Map

class AtomFeed(var feedpath:String) extends Feed {
  private val feed:Elem = XML.load(feedpath)
  
  if (feed.label.toLowerCase() != "feed"){
    throw new IllegalArgumentException(feedpath + " is not a valid atom file")
  }
  
  override val name =  feed \ "title"
  val entries = feed \\ "entry"
  
  override val articles = entries.map( x => new AtomFeedItem(x) )
}

class AtomFeedItem(n:Node) extends TItem{
  val title = (n \ "title").text
  val url = (n \ "link" \ "@href").text
  
  val contents = (n \ "content").text
  val author = (n \ "author" \ "name").text
  val date = (n \ "updated").text 
}

