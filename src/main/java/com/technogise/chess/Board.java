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

    public void setPiece(Piece piece, String position) throws InvalidPositionException {
        if(!isValidPosition(position)) throw new InvalidPositionException();
        Cell cell = getCellFor(position);
        cell.setPiece(piece);
        piece.setBoard(this);
    }

    private boolean isValidPosition(String position) {
        return position != null && position.matches("[A-H][1-8]");
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

    public String getPiecePosition(Piece piece) {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if (cell.getPiece() == piece) {
                    return cell.getPosition();
                }
            }
        }
        return null;
    }

}
