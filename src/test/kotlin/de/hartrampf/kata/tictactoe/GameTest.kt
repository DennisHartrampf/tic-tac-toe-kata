package de.hartrampf.kata.tictactoe

import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GameTest {

    private lateinit var game: Game
    private lateinit var gameBoard: GameBoard

    @BeforeEach
    internal fun setUp() {
        gameBoard = mockk(relaxed = true)
        game = Game(gameBoard)
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
}