package ca.sheridancollege.project;

/**
 * A class to model a player in the game.
 */
public class Player {
    private static int idCounter = 0;
    private int id;
    private String name;
    private int score;

    public Player(String name) {
        this.id = ++idCounter;
        this.name = name;
        this.score = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        this.score += points;
    }

    @Override
    public String toString() {
        return "Player ID: " + id + ", Name: " + name + ", Score: " + score;
    }
}
