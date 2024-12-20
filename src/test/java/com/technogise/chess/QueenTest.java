package com.technogise.chess;

import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class QueenTest {

    @Test
    void shouldMoveMultipleStepsInAllDirections() throws InvalidPositionException {
        Board board = new Board();
        Piece queen = new Queen();
        board.setPiece(queen, "B2");
        Set<String> possibleMovements = queen.getPossibleMovements();
        assertEquals(Set.of("A2", "C2", "D2", "E2", "F2", "G2", "H2", "B1", "B3", "B4", "B5", "B6", "B7", "B8", "C3", "D4", "E5", "F6", "G7", "H8", "A3", "C1", "A1"), possibleMovements);
    }
}