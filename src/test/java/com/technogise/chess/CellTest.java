package com.technogise.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void cellShouldHaveValidPosition() {
        Board board = new Board();
        Cell[][] cells = board.getCells();
        Cell cell = cells[2][5];
        assertEquals("F6", cell.getPosition());
    }
}