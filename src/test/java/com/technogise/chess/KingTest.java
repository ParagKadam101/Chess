package com.technogise.chess;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    private final Board board = new Board();
    private Piece king;
    private Set<String> possibleMovements;

    @Test
    void shouldMoveOneStepInAllDirectionsIfSpaceAvailable() throws InvalidPositionException {
        given().chessBoard().and().kingAt("D4").when().kingSelected().then().verifyMovementAt(Set.of("D5","E5","E4","E3","D3","C3","C4","C5"));
    }

    @Test
    void shouldNotMoveOneStepForwardIfNoSpaceAvailable() throws InvalidPositionException {
        given().chessBoard().and().kingAt("A8").when().kingSelected().then().verifyMovementAt(Set.of("B8","B7","A7"));
    }

    @Test
    void shouldNotMoveOneStepForwardRightDiagonalIfNoSpaceAvailable() throws InvalidPositionException {
        given().chessBoard().and().kingAt("H8").when().kingSelected().then().verifyMovementAt(Set.of("G8","G7","H7"));
    }

    @Test
    void shouldNotMoveOneStepRightIfNoSpaceAvailable() throws InvalidPositionException {
        given().chessBoard().and().kingAt("H4").when().kingSelected().then().verifyMovementAt(Set.of("H5","G5","G4","G3","H3"));
    }

    @Test
    void shouldNotMoveOneStepBackwardRightDiagonalIfNoSpaceAvailable() throws InvalidPositionException {
        given().chessBoard().and().kingAt("H3").when().kingSelected().then().verifyMovementAt(Set.of("H4","G4","G3","G2","H2"));
    }

    @Test
    void shouldNotMoveOneStepBackwardIfNoSpaceAvailable() throws InvalidPositionException {
        given().chessBoard().and().kingAt("A1").when().kingSelected().then().verifyMovementAt(Set.of("A2","B2","B1"));
    }

    @Test
    void shouldNotMoveOneStepBackwardLeftDiagonalIfNoSpaceAvailable() throws InvalidPositionException {
        given().chessBoard().and().kingAt("A7").when().kingSelected().then().verifyMovementAt(Set.of("A8","B8","B7","B6","A6"));
    }

    @Test
    void shouldNotMoveOneStepLeftIfNoSpaceAvailable() throws InvalidPositionException {
        given().chessBoard().and().kingAt("A3").when().kingSelected().then().verifyMovementAt(Set.of("A4","B4","B3","B2","A2"));
    }

    @Test
    void shouldNotMoveOneStepForwardLeftDiagonalIfNoSpaceAvailable() throws InvalidPositionException {
        given().chessBoard().and().kingAt("F8").when().kingSelected().then().verifyMovementAt(Set.of("E8","E7","F7","G7","G8"));
    }


    private void verifyMovementAt(Set<String> movements) {
        assertEquals(movements, this.possibleMovements);
    }

    private KingTest then() {
        return this;
    }

    private KingTest kingSelected() {
        possibleMovements = king.getPossibleMovements();
        return this;
    }

    private KingTest when() {
        return this;
    }

    private KingTest kingAt(String position) throws InvalidPositionException {
        king = new King();
        board.setPiece(king, position);
        return this;
    }

    private KingTest and() {
        return this;
    }

    private KingTest chessBoard() {
        return this;
    }

    private KingTest given() {
        return this;
    }
}