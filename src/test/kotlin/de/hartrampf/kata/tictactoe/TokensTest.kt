package de.hartrampf.kata.tictactoe

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class TokensTest {

    @Test
    fun testValues() {
        assertThat(Tokens.values()).containsExactly(Tokens.EMPTY, Tokens.PLAYER_ONE, Tokens.PLAYER_TWO)
    }

    @Test
    fun testDisplayAs() {
        assertThat(Tokens.values().map(Tokens::displayAs)).containsExactly(" ", "X", "O")
    }

}