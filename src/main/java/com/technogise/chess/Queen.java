package com.technogise.chess;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.technogise.chess.Direction.*;

public class Queen extends Piece {

    @Override
    public Set<String> getPossibleMovements() {
        String currentPosition = getBoard().getPiecePosition(this);
        return Stream.of(
            getMovementsFor(currentPosition, FORWARD, 7),
            getMovementsFor(currentPosition, FORWARD_RIGHT_DIAGONAL, 7),
            getMovementsFor(currentPosition, RIGHT, 7),
            getMovementsFor(currentPosition, BACKWARD_RIGHT_DIAGONAL, 7),
            getMovementsFor(currentPosition, BACKWARD, 7),
            getMovementsFor(currentPosition, BACKWARD_LEFT_DIAGONAL, 7),
            getMovementsFor(currentPosition, LEFT, 7),
            getMovementsFor(currentPosition, FORWARD_LEFT_DIAGONAL, 7)
        )
        .flatMap(Collection::stream)
        .collect(Collectors.toSet());
    }
}
