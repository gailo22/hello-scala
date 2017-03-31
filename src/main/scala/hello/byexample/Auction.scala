package hello.byexample

import akka.actor.Actor
import akka.actor.ActorRef
import akka.event.Logging
import akka.actor.Props
import akka.actor.ActorSystem
import scala.io.Source
import scala.collection._
import java.util.Date

object Auction {

  abstract class AuctionMessage
  case class Offer(bid: Int, client: ActorRef) extends AuctionMessage
  case class Inquire(client: ActorRef)         extends AuctionMessage
  
  abstract class AuctionReply
  case class Status(asked: Int, expire: Date) extends AuctionReply
  case object BestOffer                       extends AuctionReply
  case class BeatenOffer(maxBid: Int)         extends AuctionReply
  case class AuctionConcluded(seller: ActorRef, client: ActorRef) 
                                              extends AuctionReply
  case object AuctionFailed                   extends AuctionReply
  case object AuctionOver                     extends AuctionReply
  
  class Auction(seller: ActorRef, minBid: Int, closing: Date) extends Actor {
    val timeToShutdown = 36000000
    val bidIncrement = 10
    
    def receive = {
      case _ => ???  
    }
    
    def act() {
      var maxBid = minBid - bidIncrement
      var maxBidder: ActorRef = null
      var running = true
      while (running) {
//        receiveWithin ((closing.getTime - new Date().getTime())) {
//          case Offer(bid, client) =>
//            if (bid >= maxBid + bidIncrement) {
//              if (maxBid >= minBid) maxBidder ! BeatenOffer(bid)
//              maxBid = bid; maxBidder = client; client ! BestOffer
//            } else {
//              client ! BeatenOffer(maxBid)
//            }
//          case Inquire(client) =>
//            client ! Status(maxBid, closing)
//          case TIMEOUT =>
//            if (maxBid >= minBid) {
//              val reply = AuctionConcluded(seller, maxBidder)
//              maxBidder ! reply; seller ! reply
//            } else {
//              seller ! AuctionFailed
//            }
//            receiveWithin(timeToShutdown) {
//              case Offer(_, client) => client ! AuctionOver
//              case TIMEOUT => running = false
//            }
//        }
      }
    }
  }
  
}