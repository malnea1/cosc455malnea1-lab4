package edu.towson.cosc.cosc455.malnea1.lab4


import scala.io.Source

object Compiler {

  // currentToken variable
  var currentToken : String = ""

  val Scanner = new LexicalAnalyzer
  val Parser = new SyntaxAnalyzer

  def main(args: Array[String]) = {

    // get input file name from command line argument
    val filename: String = args(0)

    // for each line read from file, scan and parse
    for (line <- Source.fromFile(filename).getLines()) {
      // get the first token
      Scanner.start(line)

      // Parse the given sentence against the given grammar. We assume that the
      // sentence, <S>, production is the start state.
      Parser.Sentence()

      // If a syntax error was discovered, print that the sentence follows the grammar.
      if(Parser.getError)
        println("The sentence '" + line + "' does not follow the BNF grammar.")
      // If no syntax error was found, print that the sentence does not follow the grammar.
      else
       println("The sentence '" + line + "' follows the BNF grammar.")

    }
  }

}
