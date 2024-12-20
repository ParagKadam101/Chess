package com.technogise.chess;

public class Board {
    private final Cell[][] cells = new Cell[8][8];

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                char columnChar = (char) ('A' + col);
                int rowNum = 8 - row;
                String position = columnChar + String.valueOf(rowNum);
                cells[row][col] = new Cell(position);
            }
        }
    }

    public void setPiece(Piece piece) throws InvalidPositionException {
        String position = piece.getPosition();
        Cell cell = getCellFor(position);
        cell.setPiece(piece);
    }

    private Cell getCellFor(String position) throws InvalidPositionException {
        for (Cell[] cell : cells) {
            for (Cell value : cell) {
                if (value.getPosition().equals(position)) {
                    return value;
                }
            }
        }
        throw new InvalidPositionException();
    }

    public Cell[][] getCells() {
        return cells;
    }
}
