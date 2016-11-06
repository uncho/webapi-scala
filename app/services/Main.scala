package services

import akka.actor.{Props, ActorSystem}

class Main extends App{

	// アクターシステムの生成
	val system = ActorSystem("system")

	// アクター ApiServer の生成
	val actor = system.actorOf(Props[ApiServer])
}
