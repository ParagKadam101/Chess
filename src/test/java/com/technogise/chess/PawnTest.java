package com.technogise.chess;

import org.junit.jupiter.api.Test;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PawnTest {

    private Pawn pawn;
    private Set<String> possibleMovements;

    @Test
    void pawnShouldMoveOneStepForward() throws InvalidPositionException {
        given().pawnAt("B4")
            .when().pawnSelected()
            .then().shouldMoveOnlyOneStepForward(Set.of("B5"));
    }

    @Test
    void pawnShouldNotMoveIfNoSpace() throws InvalidPositionException {
        given().pawnAt("B8")
                .when().pawnSelected()
                .then().shouldMoveOnlyOneStepForward(Set.of());
    }

    private void shouldMoveOnlyOneStepForward(Set<String> possibleMovements) {
        assertEquals(possibleMovements, this.possibleMovements);
    }

    private PawnTest then() {
        return this;
    }

    private PawnTest pawnSelected() {
        possibleMovements = pawn.getPossibleMovements();
        return this;
    }

    private PawnTest when() {
        return this;
    }

    private PawnTest pawnAt(String position) throws InvalidPositionException {
        pawn = new Pawn(position);
        return this;
    }

    private PawnTest given() {
        return this;
    }
}