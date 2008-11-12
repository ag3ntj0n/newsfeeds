package newsfeeds.feeds

trait TItem {
  val title:String
  val url:String
  
  val contents:String
  val author:String
  val date:String
}
