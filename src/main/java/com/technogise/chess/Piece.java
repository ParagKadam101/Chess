package com.technogise.chess;


import java.util.HashSet;
import java.util.Set;

public abstract class Piece {

    public abstract Set<String> getPossibleMovements();
    private Board board;

    public static Set<String> getMovementsFor(String currentPosition, Direction direction, int steps) {
        int row = Integer.parseInt(currentPosition.substring(1, 2));
        String column = currentPosition.substring(0, 1);

        int rowOffset = 0;
        int colOffset = 0;

        switch (direction) {
            case FORWARD -> rowOffset = 1;
            case BACKWARD -> rowOffset = -1;
            case RIGHT -> colOffset = 1;
            case LEFT -> colOffset = -1;
            case FORWARD_RIGHT_DIAGONAL -> { rowOffset = 1; colOffset = 1; }
            case BACKWARD_RIGHT_DIAGONAL -> { rowOffset = -1; colOffset = 1; }
            case BACKWARD_LEFT_DIAGONAL -> { rowOffset = -1; colOffset = -1; }
            case FORWARD_LEFT_DIAGONAL -> { rowOffset = 1; colOffset = -1; }
        }

        return calculateMovements(row, column, rowOffset, colOffset, steps);
    }

    private static Set<String> calculateMovements(int row, String column, int rowOffset, int colOffset, int steps) {
        Set<String> movements = new HashSet<>();
        for (int i = 0; i < steps; i++) {
            row += rowOffset;
            column = getNextAlphabet(column, colOffset);

            if (row >= 1 && row <= 8 && column != null) {
                movements.add(column + row);
            } else {
                break;
            }
        }
        return movements;
    }


    private static String getNextAlphabet(String alphabet, int offset) {
        char startChar = alphabet.charAt(0);
        char newChar = (char) (startChar + offset);
        if (newChar < 'A' || newChar > 'H') {
            return null;
        }
        return String.valueOf(newChar);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }
}


