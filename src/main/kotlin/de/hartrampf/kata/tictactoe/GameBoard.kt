package de.hartrampf.kata.tictactoe

import de.hartrampf.kata.tictactoe.Tokens.*

class GameBoard {
    fun placeToken(player: Players, coordinates: Coordinates): Boolean {
        return if (board[coordinates.y][coordinates.x] != EMPTY) {
            false
        } else {
            board[coordinates.y][coordinates.x] = player.token
            true
        }
    }

    val board: Array<Array<Tokens>> = arrayOf(arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY))
        get() {
            return field.copyOf()
        }

}