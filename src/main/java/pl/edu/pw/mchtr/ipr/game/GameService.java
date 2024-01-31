package pl.edu.pw.mchtr.ipr.game;

import java.util.List;

public final class GameService {
    private static GameService instance;

    private GameService() {

    }

    public static GameService getInstance() {
        if (instance == null) {
            instance = new GameService();
        }
        return instance;
    }

    public void update() {

    }

    public Game getActiveGame(int id) {
        return null;
    }

    public List<Game> getOpenGames() {
        return null;
    }

    public Game getGame(String name) {
        return null;
    }

    public Game newGame(String name) {
        return null;
    }

}
