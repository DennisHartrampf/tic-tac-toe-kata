package de.hartrampf.kata.tictactoe

import de.hartrampf.kata.tictactoe.Tokens.*
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.Console

internal class GameBoardConsoleControllerTest {

    private lateinit var console: Console
    private lateinit var board: GameBoard
    private lateinit var controller: GameBoardConsoleController

    @BeforeEach
    internal fun setUp() {
        console = mockk(relaxed = true)
        board = mockk(relaxed = true)
        controller = GameBoardConsoleController(board, console)
    }

    @Test
    fun testClassExists() {
        assertThat(controller).isNotNull
    }

    @Test
    fun testVisualize_emptyBoard() {
        every { board.board } returns arrayOf(arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY))
        controller.visualize()

        verify { console.printf("  A | B | C%n") }
        verify { console.printf("%s %s | %s | %s%n", "0", " ", " ", " ") }
        verify { console.printf("----+---+---%n") }
        verify { console.printf("%s %s | %s | %s%n", "1", " ", " ", " ") }
        verify { console.printf("----+---+---%n") }
        verify { console.printf("%s %s | %s | %s%n", "2", " ", " ", " ") }
    }

    @Test
    fun testPlayerOneCanPlaceToken() {
        every { console.readLine() } returns "A0"
        assertThat(controller.getNextCommand()).isEqualTo("A0")
    }

    @Test
    fun testVisualize_oneTokenPlaced() {
        every { board.board } returns arrayOf(arrayOf(PLAYER_ONE, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY))
        controller.visualize()

        verify { console.printf("  A | B | C%n") }
        verify { console.printf("%s %s | %s | %s%n", "0", "X", " ", " ") }
        verify { console.printf("----+---+---%n") }
        verify { console.printf("%s %s | %s | %s%n", "1", " ", " ", " ") }
        verify { console.printf("----+---+---%n") }
        verify { console.printf("%s %s | %s | %s%n", "2", " ", " ", " ") }
    }

    @Test
    fun testVisualize_manyTokensPlaced() {
        every { board.board } returns arrayOf(arrayOf(PLAYER_ONE, PLAYER_TWO, EMPTY), arrayOf(PLAYER_TWO, PLAYER_ONE, EMPTY), arrayOf(PLAYER_ONE, PLAYER_TWO, PLAYER_ONE))
        controller.visualize()

        verify { console.printf("  A | B | C%n") }
        verify { console.printf("%s %s | %s | %s%n", "0", "X", "O", " ") }
        verify { console.printf("----+---+---%n") }
        verify { console.printf("%s %s | %s | %s%n", "1", "O", "X", " ") }
        verify { console.printf("----+---+---%n") }
        verify { console.printf("%s %s | %s | %s%n", "2", "X", "O", "X") }
    }

    @Test
    fun testVisualize_gameOverFull() {
        every { board.board } returns arrayOf(arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY))
        every { board.winner } returns null
        every { board.isFull() } returns true
        controller.visualize()

        verify { console.printf("  A | B | C%n") }
        verify { console.printf("%s %s | %s | %s%n", "0", " ", " ", " ") }
        verify { console.printf("----+---+---%n") }
        verify { console.printf("%s %s | %s | %s%n", "1", " ", " ", " ") }
        verify { console.printf("----+---+---%n") }
        verify { console.printf("%s %s | %s | %s%n", "2", " ", " ", " ") }
        verify { console.printf("Game is draw!%n") }
    }

    @Test
    fun testVisualize_gameOverWinner() {
        every { board.board } returns arrayOf(arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY))
        every { board.winner } returns Players.ONE
        controller.visualize()

        verify { console.printf("  A | B | C%n") }
        verify { console.printf("%s %s | %s | %s%n", "0", " ", " ", " ") }
        verify { console.printf("----+---+---%n") }
        verify { console.printf("%s %s | %s | %s%n", "1", " ", " ", " ") }
        verify { console.printf("----+---+---%n") }
        verify { console.printf("%s %s | %s | %s%n", "2", " ", " ", " ") }
        verify { console.printf("Winner: %s%n", Players.ONE) }
    }
}

