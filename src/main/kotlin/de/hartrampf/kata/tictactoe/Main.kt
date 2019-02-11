package de.hartrampf.kata.tictactoe

import java.io.Console
import kotlin.system.exitProcess

fun main() {
    val console = getConsole()
    val gameBoard = GameBoard()
    val controller = GameBoardConsoleController(gameBoard, console)
    val game = Game(gameBoard, controller)
    game.play()
}

private fun getConsole(): Console {
    val console = System.console()
    if (console == null) {
        System.err.println("Must be started from console.")
        exitProcess(1)
    }
    return console
}