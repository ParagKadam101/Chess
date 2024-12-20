package com.technogise.chess;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTest {

    private final Board board = new Board();
    private boolean isPositionValid = true;
    private Piece piece;

    @Test
    void shouldNotThrowExceptionWhenPieceCreatedWithValidPosition() {
        whenI().constructPiece("C4").thenI().verifyPiecePositionIsValid(true);
    }

    @Test
    void shouldThrowExceptionWhenPieceCreatedWithInvalidPosition() {
        whenI().constructPiece("P7").thenI().verifyPiecePositionIsValid(false);
    }

    @Test
    void shouldThrowExceptionWhenPieceCreatedWithLowerCasePosition() {
        whenI().constructPiece("a5").thenI().verifyPiecePositionIsValid(false);
    }

    @Test
    void shouldGetSamePositionAsWasSet() {
        whenI().constructPiece("D6").thenI().verifyPiecePositionIsSameAsWasSet("D6");
    }

    private void verifyPiecePositionIsSameAsWasSet(String position) {
        assertEquals(position, piece.getBoard().getPiecePosition(piece));
    }

    private void verifyPiecePositionIsValid(boolean isPositionValid) {
        assertEquals(isPositionValid, this.isPositionValid);
    }

    private PieceTest thenI() {
        return this;
    }

    private PieceTest constructPiece(String position) {
        try {
            piece = new Pawn();
            board.setPiece(piece, position);
        } catch (InvalidPositionException e) {
            isPositionValid = false;
        }
        return this;
    }

    private PieceTest whenI() {
        return this;
    }
}