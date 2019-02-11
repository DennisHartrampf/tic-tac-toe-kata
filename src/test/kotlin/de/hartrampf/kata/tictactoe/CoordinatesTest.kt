package de.hartrampf.kata.tictactoe

import de.hartrampf.kata.tictactoe.Coordinates.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CoordinatesTest {

    @Test
    fun testValues() {
        assertThat(values()).containsExactlyInAnyOrder(
                A0, B0, C0,
                A1, B1, C1,
                A2, B2, C2)
    }

    @Test
    fun testDiagonals() {
        assertThat(Coordinates.diagonal1).containsExactlyInAnyOrder(A0, B1, C2)
        assertThat(Coordinates.diagonal2).containsExactlyInAnyOrder(C0, B1, A2)
    }

}