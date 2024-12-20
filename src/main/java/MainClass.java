import com.technogise.chess.*;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) throws InvalidPositionException {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 'exit' to quit");
        String input;
        while (true) {
            System.out.print("\nInput - ");
            input = scanner.nextLine();
            if(input.equals("exit")) break;
            Piece piece = getPiece(input);
            board.setPiece(piece);
            List<String> possibleMovements = piece.getPossibleMovements().stream().sorted().collect(Collectors.toList());
            String movementsString = String.join(", ", possibleMovements);
            System.out.println(movementsString);
        }
    }

    private static Piece getPiece(String input) throws InvalidPositionException {
        String[] pieceAndPosition = input.replaceAll("\\s", "").split(",");
        String pieceName = pieceAndPosition[0];
        String piecePosition = pieceAndPosition[1];
        return switch (pieceName) {
            case "Pawn"  -> new Pawn(piecePosition);
            case "Queen" -> new Queen(piecePosition);
            case "King"  -> new King(piecePosition);
            default -> throw new IllegalArgumentException("Invalid piece entered: " + pieceName);
        };
    }
}
