package de.hartrampf.kata.tictactoe

class Game(private val gameBoard: GameBoard) {
    val isOver: Boolean
        get() {
            return gameBoard.isFull() || gameBoard.winner != null
        }

}
