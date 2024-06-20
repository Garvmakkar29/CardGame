package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;

/**
 * A class to model the game.
 */
public class Game {
    private List<Player> players;
    private GroupOfCards deck;

    public Game() {
        players = new ArrayList<>();
        deck = new GroupOfCards();
        initializeDeck();
    }

    public void addPlayer(String name) {
        players.add(new Player(name));
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String value : values) {
                deck.addCard(new Card(suit, value));
            }
        }
        deck.shuffle();
    }

    public void playRound(Player player) {
        Card drawnCard = deck.drawCard();
        System.out.println(player.getName() + " drew: " + drawnCard);

        // Simplified scoring logic
        int points = getCardValue(drawnCard);
        player.addScore(points);
        System.out.println(player.getName() + " scores " + points + " points. Total score: " + player.getScore());

        if (deck.getSize() == 0) {
            System.out.println("Deck is empty. Ending game.");
        }
    }

    private int getCardValue(Card card) {
        switch (card.getValue()) {
            case "Ace":
                return 11;
            case "King":
            case "Queen":
            case "Jack":
                return 10;
            default:
                return Integer.parseInt(card.getValue());
        }
    }

    public boolean isDeckEmpty() {
        return deck.getSize() == 0;
    }

    public void declareWinner() {
        Player winner = players.get(0);
        for (Player player : players) {
            if (player.getScore() > winner.getScore()) {
                winner = player;
            }
        }
        System.out.println("The winner is " + winner.getName() + " with a score of " + winner.getScore());
    }

    public void displayPlayerStatus() {
        for (Player player : players) {
            System.out.println(player);
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
