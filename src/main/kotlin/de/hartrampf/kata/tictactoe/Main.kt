package de.hartrampf.kata.tictactoe

import kotlin.system.exitProcess

fun main() {
    val console = System.console()
    if (console == null) {
        System.err.println("Must be started from console.")
        exitProcess(1)
    }
    val gameBoard = GameBoard()
    val controller = GameBoardConsoleController(gameBoard, console)
    var player = 0
    while (true) {
        controller.visualize()
        val nextCommand = controller.getNextCommand()
        gameBoard.placeToken(Players.values()[player], nextCommand)
        player = (player + 1) % 2
    }
}