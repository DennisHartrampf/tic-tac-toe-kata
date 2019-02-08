package de.hartrampf.kata.tictactoe

import de.hartrampf.kata.tictactoe.Tokens.*
import de.hartrampf.kata.tictactoe.Coordinates.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.ObjectArrayAssert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameBoardTest {

    private lateinit var gameBoard: GameBoard

    @BeforeEach
    internal fun setUp() {
        gameBoard = GameBoard()
    }

    @Test
    fun testClassExists() {
        assertThat(gameBoard).isNotNull
    }

    @Test
    fun testBoard_initiallyEmpty() {
        assertThat(gameBoard.board).isEmptyBoard()
    }

    @Test
    fun testPlaceToken() {
        assertThat(gameBoard.board).isEmptyBoard()

        gameBoard.placeToken(Players.ONE, A0)
        assertThat(gameBoard.board).isEqualTo(arrayOf(arrayOf(PLAYER_ONE, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY)))

        gameBoard.placeToken(Players.TWO, B1)
        assertThat(gameBoard.board).isEqualTo(arrayOf(arrayOf(PLAYER_ONE, EMPTY, EMPTY), arrayOf(EMPTY, PLAYER_TWO, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY)))

        gameBoard.placeToken(Players.TWO, C0)
        assertThat(gameBoard.board).isEqualTo(arrayOf(arrayOf(PLAYER_ONE, EMPTY, PLAYER_TWO), arrayOf(EMPTY, PLAYER_TWO, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY)))
    }

    @Test
    fun testPlaceToken_alreadyOccupied() {
        assertThat(gameBoard.board).isEmptyBoard()

        assertThat(gameBoard.placeToken(Players.ONE, A0)).isTrue()
        assertThat(gameBoard.board).isEqualTo(arrayOf(arrayOf(PLAYER_ONE, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY)))

        assertThat(gameBoard.placeToken(Players.TWO, A0)).isFalse()
        assertThat(gameBoard.board).isEqualTo(arrayOf(arrayOf(PLAYER_ONE, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY)))

        assertThat(gameBoard.placeToken(Players.ONE, A0)).isFalse()
        assertThat(gameBoard.board).isEqualTo(arrayOf(arrayOf(PLAYER_ONE, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY)))
    }

    private fun <ELEMENT> ObjectArrayAssert<ELEMENT>.isEmptyBoard(): ObjectArrayAssert<ELEMENT> {
        return this.isEqualTo(arrayOf(arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY)))
    }
}

