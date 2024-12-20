package com.technogise.chess;

import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceTests {
    
    private Board board;
    private Set<String> possibleMovements;

    @Test
    void pawn_can_move_1_step_in_forward_direction() throws InvalidPositionException {
        Piece pawn = new Pawn();
        given().chessBoard().and().piece(pawn, "G1")
                .whenI().selectPieceToMove(pawn)
                .thenI().verifyPossiblePieceMovements(Set.of("G2"));
    }

    @Test
    void king_can_move_1_step_in_all_8_direction() throws InvalidPositionException {
        Piece king = new King();
        given().chessBoard().and().piece(king, "D5")
                .whenI().selectPieceToMove(king)
                .thenI().verifyPossiblePieceMovements(Set.of("C4", "C5", "C6", "D4", "D6", "E4", "E5", "E6"));
    }

    @Test
    void queen_can_move_all_8_direction() throws InvalidPositionException {
        Piece queen = new Queen();
        given().chessBoard().and().piece(queen, "E4")
                .whenI().selectPieceToMove(queen)
                .thenI().verifyPossiblePieceMovements(Set.of("A4", "B4", "C4", "D4", "F4", "G4", "H4", "E1", "E2", "E3", "E5", "E6", "E7", "E8", "A8", "B7", "C6", "D5", "F3", "G2", "H1", "B1", "C2", "D3", "F5", "G6", "H7"));
    }

    private void verifyPossiblePieceMovements(Set<String> possibleMovements) {
        assertEquals(possibleMovements, this.possibleMovements);
    }

    private AcceptanceTests thenI() {
        return this;
    }

    private AcceptanceTests selectPieceToMove(Piece piece) {
        possibleMovements = piece.getPossibleMovements();
        return this;
    }

    private AcceptanceTests whenI() {
        return this;
    }

    private AcceptanceTests piece(Piece piece, String position) throws InvalidPositionException {
        board.setPiece(piece, position);
        return this;
    }

    private AcceptanceTests and() {
        return this;
    }

    private AcceptanceTests chessBoard() {
        board = new Board();
        return this;
    }

    private AcceptanceTests given() {
        return this;
    }
}
