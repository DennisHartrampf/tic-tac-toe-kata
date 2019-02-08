package de.hartrampf.kata.tictactoe

import java.io.Console
import kotlin.system.exitProcess

fun main() {
    val console = getConsole()
    val gameBoard = GameBoard()
    val controller = GameBoardConsoleController(gameBoard, console)
    var player = 0
    while (true) {
        controller.visualize()
        val nextCommand = controller.getNextCommand()
        val coordinates = Coordinates.valueOf(nextCommand)
        if (gameBoard.placeToken(Players.values()[player], coordinates)) {
            player = (player + 1) % 2
        }
    }
}

private fun getConsole(): Console {
    val console = System.console()
    if (console == null) {
        System.err.println("Must be started from console.")
        exitProcess(1)
    }
    return console
}