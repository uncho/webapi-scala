package services

import akka.actor.Actor

class ApiServer extends Actor {
	def receive = {
		case "Hello" => println("World")
	}
}
