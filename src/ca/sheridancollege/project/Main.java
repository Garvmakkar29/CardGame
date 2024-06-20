package ca.sheridancollege.project;

import java.util.Scanner;

/**
 * A class to handle the user interface and game flow.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = 0;

        // Validate number of players input
        while (true) {
            System.out.println("Enter number of players:");
            if (scanner.hasNextInt()) {
                numberOfPlayers = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (numberOfPlayers > 0) {
                    break;
                } else {
                    System.out.println("Number of players must be greater than 0.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Consume invalid input
            }
        }

        // Input player names
        for (int i = 0; i < numberOfPlayers; i++) {
            System.out.println("Enter name for player " + (i + 1) + ":");
            String playerName = scanner.nextLine();
            game.addPlayer(playerName);
        }

        System.out.println("Starting the game!");

        while (!game.isDeckEmpty()) {
            for (Player player : game.getPlayers()) {
                System.out.println(player.getName() + "'s turn. Press Enter to draw a card.");
                scanner.nextLine();
                game.playRound(player);

                if (game.isDeckEmpty()) {
                    break;
                }
            }
        }

        game.declareWinner();
        game.displayPlayerStatus();
    }
}
