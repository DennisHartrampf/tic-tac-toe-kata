package de.hartrampf.kata.tictactoe

class Game(private val gameBoard: GameBoard, private val controller: GameBoardConsoleController) {
    val isOver: Boolean
        get() {
            return gameBoard.isFull() || gameBoard.winner != null
        }

    fun play() {
        var player = 0
        controller.visualize()
        while (!isOver) {
            val nextCommand = controller.getNextCommand()
            val coordinates = Coordinates.valueOf(nextCommand)
            if (gameBoard.placeToken(Players.values()[player], coordinates)) {
                player = (player + 1) % 2
            }
            controller.visualize()
        }
    }
}
