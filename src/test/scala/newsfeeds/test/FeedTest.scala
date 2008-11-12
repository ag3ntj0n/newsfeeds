package newsfeeds.test
import junit.framework.TestCase
import org.junit.Assert._
import org.junit.Test
import newsfeeds.feeds._
import newsfeeds.aggregate._

import java.util.Date

class FeedTest extends TestCase{
  @Test
  def testRSS() = {
    var rss = new RssFeed("src/test/resources/HomePage.xml")
    var reddit = new RssFeed("src/test/resources/scalareddit.xml")
 
    assertTrue(reddit.articles.length > 0)
    assertTrue(rss.articles.length > 0)
  }
  
  @Test
  def testAtom() = {
    var atom = new AtomFeed("src/test/resources/atom.xml")
   // atom.articles.foreach(e => println(e.title))
    
    assertTrue(atom.articles.length > 0)
  }

  @Test
  def testOpml() = {
    var opml = new OpmlFeed("src/test/resources/google-reader-subscriptions.xml")
 //   opml.items.foreach( entry => println(entry \ "@text" + ", "+ entry \ "@xmlUrl") )
    assertTrue(opml.articles.length > 0)
  }
  /*
  def printFeedLen(f:Feed) = {
    println( f.articles.length + " items in " + f.name.text )
  }
   */
}