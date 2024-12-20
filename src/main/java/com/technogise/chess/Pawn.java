package com.technogise.chess;

import java.util.Set;

public class Pawn extends Piece {

    public Pawn(String position) throws InvalidPositionException {
        super(position);
    }


    @Override
    public Set<String> getPossibleMovements() {
        String currentPosition = getPosition();
        return getMovementsFor(currentPosition, Direction.FORWARD, 1);
    }

}
