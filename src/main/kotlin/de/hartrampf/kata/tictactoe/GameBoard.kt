package de.hartrampf.kata.tictactoe

import de.hartrampf.kata.tictactoe.Tokens.*

class GameBoard {
    fun placeToken(player: Players, coordinates: String) {
        board[coordinates[1].toString().toInt()][when (coordinates[0]) {
            'A' -> 0
            'B' -> 1
            'C' -> 2

            else -> throw IllegalStateException()
        }] = player.token
    }

    val board: Array<Array<Tokens>> = arrayOf(arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY))
        get() {
            return field.copyOf()
        }

}