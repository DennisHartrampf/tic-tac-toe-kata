package de.hartrampf.kata.tictactoe

import de.hartrampf.kata.tictactoe.Coordinates.*
import de.hartrampf.kata.tictactoe.Tokens.*
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.ObjectArrayAssert
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

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

    @Test
    fun testIsFull() {
        assertThat(gameBoard.isFull()).isFalse()
        for (coordinate in Coordinates.values()) {
            gameBoard.placeToken(Players.ONE, coordinate)
        }
        assertThat(gameBoard.isFull()).isTrue()
    }

    @Test
    fun testGetWinner_initiallyNull() {
        assertThat(gameBoard.winner).isNull()
    }

    @ParameterizedTest
    @CsvSource(
            "ONE, A0, B0, C0", "ONE, A1, B1, C1", "ONE, A2, B2, C2",
            "TWO, A0, B0, C0", "TWO, A1, B1, C1", "TWO, A2, B2, C2"
    )
    fun testGetWinner_horizontal(player: Players, c1: Coordinates, c2: Coordinates, c3: Coordinates) {
        gameBoard.placeToken(player, c1)
        gameBoard.placeToken(player, c2)
        gameBoard.placeToken(player, c3)

        assertThat(gameBoard.winner).isEqualTo(player)
    }

    @ParameterizedTest
    @CsvSource(
            "ONE, A0, A1, A2", "ONE, B0, B1, B2", "ONE, C0, C1, C2",
            "TWO, A0, A1, A2", "TWO, B0, B1, B2", "TWO, C0, C1, C2"
    )
    fun testGetWinner_vertical(player: Players, c1: Coordinates, c2: Coordinates, c3: Coordinates) {
        gameBoard.placeToken(player, c1)
        gameBoard.placeToken(player, c2)
        gameBoard.placeToken(player, c3)

        assertThat(gameBoard.winner).isEqualTo(player)
    }

    @ParameterizedTest
    @CsvSource(
            "ONE, A0, B1, C2", "ONE, C0, B1, A2",
            "TWO, A0, B1, C2", "TWO, C0, B1, A2"
    )
    fun testGetWinner_diagonal(player: Players, c1: Coordinates, c2: Coordinates, c3: Coordinates) {
        gameBoard.placeToken(player, c1)
        gameBoard.placeToken(player, c2)
        gameBoard.placeToken(player, c3)

        assertThat(gameBoard.winner).isEqualTo(player)
    }

    private fun <ELEMENT> ObjectArrayAssert<ELEMENT>.isEmptyBoard(): ObjectArrayAssert<ELEMENT> {
        return this.isEqualTo(arrayOf(arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY), arrayOf(EMPTY, EMPTY, EMPTY)))
    }
}

