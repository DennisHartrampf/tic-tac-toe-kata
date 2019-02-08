package de.hartrampf.kata.tictactoe

import de.hartrampf.kata.tictactoe.Tokens.*

class GameBoard {
    fun placeToken(player: Players, coordinates: Coordinates) {
        board[coordinates.y][coordinates.x] = player.token
    }

    val board: Array<Array<Tokens>> = arrayOf(arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY))
        get() {
            return field.copyOf()
        }

}