package com.technogise.chess;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.technogise.chess.Direction.*;

public class King extends Piece {
    public King(String position) throws InvalidPositionException {
        super(position);
    }

    @Override
    public Set<String> getPossibleMovements() {
        String currentPosition = getPosition();
        return Stream.of(
                    getMovementsFor(currentPosition, FORWARD, 1),
                    getMovementsFor(currentPosition, FORWARD_RIGHT_DIAGONAL, 1),
                    getMovementsFor(currentPosition, RIGHT, 1),
                    getMovementsFor(currentPosition, BACKWARD_RIGHT_DIAGONAL, 1),
                    getMovementsFor(currentPosition, BACKWARD, 1),
                    getMovementsFor(currentPosition, BACKWARD_LEFT_DIAGONAL, 1),
                    getMovementsFor(currentPosition, LEFT, 1),
                    getMovementsFor(currentPosition, FORWARD_LEFT_DIAGONAL, 1)
                )
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }
}
