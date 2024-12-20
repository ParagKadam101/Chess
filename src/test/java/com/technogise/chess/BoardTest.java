package com.technogise.chess;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private final Board board = new Board();
    private final Cell[][] cells = board.getCells();

    @Test
    void boardShouldHaveEightRows() {
        assertEquals(8, cells.length);
    }

    @Test
    void boardShouldHaveEightColumns() {
        assertEquals(8, cells[0].length);
    }

    @Test
    void shouldSetPieceAtTheRightPositionAsIntended() throws InvalidPositionException {
        Piece pawn = new Pawn();
        board.setPiece(pawn, "C3");
        Cell cell = board.getCells()[5][2];
        assertEquals(pawn.getBoard().getPiecePosition(pawn), cell.getPosition());
    }
}