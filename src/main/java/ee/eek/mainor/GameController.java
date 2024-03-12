package ee.eek.mainor;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class GameController {
    private static final Map<Integer, Game> games = new HashMap<>();
    private static int nextGameId = 1;

    public static void main(String[] args) {
        port(8080);

        // Endpoint to start a new game
        post("/game", (req, res) -> {
            int gameId = nextGameId++;
            Game game = new Game(gameId);
            games.put(gameId, game);
            return gameId;
        });

        // Endpoint to make a guess
        get("/game/:gameId/guess/:number", (req, res) -> {
            int gameId = Integer.parseInt(req.params(":gameId"));
            int guess = Integer.parseInt(req.params(":number"));

            Game game = games.get(gameId);
            if (game == null) {
                res.status(404);
                return "Game not found";
            }

            return game.makeGuess(guess);
        });
    }

}
