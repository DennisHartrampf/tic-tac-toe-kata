package de.hartrampf.kata.tictactoe

enum class Coordinates(val x: Int, val y: Int) {
    A0(0, 0), B0(1, 0), C0(2, 0),
    A1(0, 1), B1(1, 1), C1(2, 1),
    A2(0, 2), B2(1, 2), C2(2, 2);

    companion object {
        val diagonal1 = setOf(A0, B1, C2)
        val diagonal2 = setOf(C0, B1, A2)
    }
}
