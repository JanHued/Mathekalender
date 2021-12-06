package CinnamonStars;

import java.util.Random;

public class CinnamonStars {


    private static int simulation(int attempts, int maxMovesBlockedInARow) {

        Game game = new Game();
        Random zufall = new Random();

        for (int i = 0; i < attempts; i++) {
            switch (zufall.nextInt(4)) {
                case 0:
                    game.table2Red();
                    break;
                case 1:
                    game.table2Black();
                    break;
                case 2:
                    game.red2Table();
                    break;
                case 3:
                    game.black2Table();
                    break;
            }
            if (game.getNumberOfMovesBlockedInARow() == maxMovesBlockedInARow) {
                break;
            }
        }
        return game.getNumberOfMoves();
    }

    public static void main(String[] args) {
        int maxMoves = 0;
        int numberOfSimulations = 1000000000;
        double progress = 0;

        for (int i = 0; i < numberOfSimulations; i++) {
            int moves = simulation(100, 20);

            if (moves > maxMoves) maxMoves = moves;

            progress = (double) i * 100 / numberOfSimulations;
            if (progress % 1 == 0) System.out.println("Progress: " + (int) progress + "%");
        }
        System.out.println("Maximum number of moves: " + maxMoves);
    }
}
