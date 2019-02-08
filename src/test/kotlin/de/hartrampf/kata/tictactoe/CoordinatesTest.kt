package de.hartrampf.kata.tictactoe

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CoordinatesTest {

    @Test
    fun testValues() {
        assertThat(Coordinates.values()).containsExactlyInAnyOrder(
                Coordinates.A0, Coordinates.B0, Coordinates.C0,
                Coordinates.A1, Coordinates.B1, Coordinates.C1,
                Coordinates.A2, Coordinates.B2, Coordinates.C2)
    }

}