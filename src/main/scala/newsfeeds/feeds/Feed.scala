package newsfeeds.feeds
import scala.xml.{NodeSeq,Node}
import scala.collection.immutable.Map

import scala.Seq

trait Feed {
  val name:Seq[Node]
  val items:Seq[Node]
  val elements:Seq[TItem]
}
