package com.technogise.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private final Board board = new Board();
    private final Cell[][] cells = board.getCells();
    private final Cell cell = cells[2][5];

    @Test
    void cellShouldHaveValidPosition() {
        assertEquals("F6", cell.getPosition());
    }
}