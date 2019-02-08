package de.hartrampf.kata.tictactoe

import kotlin.system.exitProcess

fun main() {
    val console = System.console()
    if (console == null) {
        System.err.println("Must be started from console.")
        exitProcess(1)
    }
    val controller = GameBoardConsoleController(GameBoard(), console)
    controller.visualize()
}