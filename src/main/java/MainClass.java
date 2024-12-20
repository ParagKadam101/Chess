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
            String[] pieceAndPosition = input.replaceAll("\\s", "").split(",");
            String pieceName = pieceAndPosition[0];
            String piecePosition = pieceAndPosition[1];
            Piece piece = getPiece(pieceName);
            board.setPiece(piece, piecePosition);
            List<String> possibleMovements = piece.getPossibleMovements().stream().sorted().collect(Collectors.toList());
            String movementsString = String.join(", ", possibleMovements);
            System.out.println(movementsString);
        }
    }

    private static Piece getPiece(String pieceName) {
        return switch (pieceName) {
            case "Pawn"  -> new Pawn();
            case "Queen" -> new Queen();
            case "King"  -> new King();
            default -> throw new IllegalArgumentException("Invalid piece entered: " + pieceName);
        };
    }
}
