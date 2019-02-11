package de.hartrampf.kata.tictactoe

import de.hartrampf.kata.tictactoe.Tokens.EMPTY

class GameBoard {
    val board: Array<Array<Tokens>> = arrayOf(arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY))
        get() {
            return field.copyOf()
        }

    private var numberOfPlacedTokens = 0

    var winner: Players? = null
        private set

    fun placeToken(player: Players, coordinates: Coordinates): Boolean {
        return if (board[coordinates.y][coordinates.x] != EMPTY) {
            false
        } else {
            board[coordinates.y][coordinates.x] = player.token
            numberOfPlacedTokens++
            updateWinner(player, coordinates)
            true
        }
    }

    private fun updateWinner(player: Players, coordinates: Coordinates) {
        if (checkWinnerHorizontal(player, coordinates.y) || checkWinnerVertical(player, coordinates.x) || checkWinnerDiagonal(player, coordinates)) {
            winner = player
        }
    }

    private fun checkWinnerDiagonal(player: Players, coordinates: Coordinates): Boolean {
        for (diagonal in setOf(Coordinates.diagonal1, Coordinates.diagonal2)) {
            if (coordinates in diagonal) {
                if (diagonal.all { board[it.y][it.x] == player.token }) {
                    return true
                }
            }
        }

        return false
    }

    private fun checkWinnerHorizontal(player: Players, y: Int): Boolean {
        return board[y].all { it == player.token }
    }

    private fun checkWinnerVertical(player: Players, x: Int): Boolean {
        return board.all { it[x] == player.token }
    }

    fun isFull(): Boolean {
        return numberOfPlacedTokens == 9
    }

}