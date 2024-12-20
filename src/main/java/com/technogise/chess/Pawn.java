package com.technogise.chess;

import java.util.Set;

public class Pawn extends Piece {

    @Override
    public Set<String> getPossibleMovements() {
        String currentPosition = getBoard().getPiecePosition(this);
        return getMovementsFor(currentPosition, Direction.FORWARD, 1);
    }

}
