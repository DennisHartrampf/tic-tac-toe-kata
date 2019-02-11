package de.hartrampf.kata.tictactoe

import java.io.Console

class GameBoardConsoleController(private val gameBoard: GameBoard, private val console: Console) {

    fun visualize() {
        with(console) {
            printHeader()
            printLine(0)
            printLineSeparator()
            printLine(1)
            printLineSeparator()
            printLine(2)
        }
        if (gameBoard.winner != null) console.printf("Winner: %s%n", gameBoard.winner)
        else if (gameBoard.isFull()) console.printf("Game is draw!%n")
    }

    private fun Console.printHeader() {
        printf("  A | B | C%n")
    }

    private fun Console.printLineSeparator() {
        printf("----+---+---%n")
    }

    private fun Console.printLine(i: Int) {
        printf("%s %s | %s | %s%n", *getLine(i))
    }

    private fun getLine(i: Int): Array<String> {
        return arrayOf(i.toString(), *(0..2).map { gameBoard.board[i][it].displayAs }.toTypedArray())
    }

    fun getNextCommand(): String {
        return console.readLine()
    }

}