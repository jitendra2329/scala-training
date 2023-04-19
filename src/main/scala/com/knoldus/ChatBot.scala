package com.knoldus

object ChatBot extends App{

  private val chatBot: PartialFunction[String, Any] = {
    case "Hello" | "hello" => "Hii, this is Jitendra!, how can I help you?"
    case "how are you" | "How are you" => "I am fine, what about you?"
    case "can you find my phone" | "Can you find my phone" => "Sorry, I am not able to find your phone."
    case "bye" => System.exit(0)
    case _ => System.exit(0)
  }

  scala.io.Source.stdin.getLines().foreach(line => println("chatbot says : "+ chatBot(line)))
}
