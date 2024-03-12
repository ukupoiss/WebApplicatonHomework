package ee.eek.mainor;

import java.util.Random;

public class Game {
    private final int gameId;
    private final int randomNumber;
    private int guesses;

    public Game(int gameId) {
        this.gameId = gameId;
        this.randomNumber = new Random().nextInt(100) + 1; // Generate random number between 1 and 100
        this.guesses = 0;
    }

    public int getGameId() {
        return gameId;
    }

    public String makeGuess(int guess) {
        guesses++;
        if (guess < randomNumber) {
            return "Nr is bigger";
        } else if (guess > randomNumber) {
            return "Nr is smaller";
        } else {
            return "Correct, it took you " + guesses + " times";
        }
    }
}