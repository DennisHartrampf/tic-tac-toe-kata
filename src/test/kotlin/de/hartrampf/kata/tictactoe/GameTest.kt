package de.hartrampf.kata.tictactoe

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GameTest {

    private lateinit var game: Game
    private lateinit var gameBoard: GameBoard
    private lateinit var controller: GameBoardConsoleController

    @BeforeEach
    internal fun setUp() {
        gameBoard = mockk(relaxed = true)
        controller = mockk(relaxed = true)
        game = Game(gameBoard, controller)
    }

    @Test
    fun testClassExists() {
        assertThat(game).isNotNull
    }

    @Test
    fun testIsOver_initiallyFalse() {
        every { gameBoard.winner } returns null
        assertThat(game.isOver).isFalse()
    }

    @Test
    fun testIsOver_trueWhenBoardIsFull() {
        every { gameBoard.winner } returns null
        assertThat(game.isOver).isFalse()
        every { gameBoard.isFull() } returns true
        assertThat(game.isOver).isTrue()
    }

    @Test
    fun testIsOver_trueWhenWinner() {
        every { gameBoard.winner } returns null
        assertThat(game.isOver).isFalse()
        every { gameBoard.winner } returns Players.ONE
        assertThat(game.isOver).isTrue()
    }

    @Test
    fun testPlay() {
        every { gameBoard.winner }.returnsMany(null, null, Players.ONE)
        every { controller.getNextCommand() } returns "A0"

        game.play()

        verify(exactly = 3) { controller.visualize() }
        verify(exactly = 2) { controller.getNextCommand() }
        verify(exactly = 2) { gameBoard.placeToken(Players.ONE, Coordinates.A0) }
    }
}