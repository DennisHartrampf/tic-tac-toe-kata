package de.hartrampf.kata.tictactoe

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PlayersTest {

    @Test
    fun testValues() {
        assertThat(Players.values()).containsExactly(Players.ONE, Players.TWO)
    }

    @Test
    fun testTokens() {
        assertThat(Players.values().map(Players::token)).containsExactly(Tokens.PLAYER_ONE, Tokens.PLAYER_TWO)
    }
}