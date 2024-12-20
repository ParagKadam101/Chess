package com.technogise.chess;

public class Cell {

    private final String position;
    private Piece piece;

    public Cell(String position) {
        this.position = position;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public String getPosition() {
        return position;
    }

    public Piece getPiece() {
        return piece;
    }
}
