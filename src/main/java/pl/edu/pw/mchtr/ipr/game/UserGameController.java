package pl.edu.pw.mchtr.ipr.game;

import java.util.List;

public class UserGameController implements GameController{

    private static GameService gameService;

    private UserGameController(){
        gameService = GameService.getInstance();
    }

    @Override
    public List<String> getArchiveGames(String user) {
        return null;
    }

    @Override
    public List<Ranking> getRankings() {
        return null;
    }

    @Override
    public List<String> getActiveGames() {
        return null;
    }

    @Override
    public Game startGame(String name) {
        return null;
    }

    @Override
    public String tryGame(String name) {
        Game selectedGame  = gameService.getGame(name);
        return checkGameType(selectedGame);
    }

    @Override
    public String joinTeam(String name, String team) {
        Game game = gameService.getGame(name);
        //TODO wywołanie methody z klasy potomnej
        if(game  )
        var teams = game

        return null;
    }

    @Override
    public String checkGameType(Game game) {
        return null;
    }

    @Override
    public boolean teamExist(String name, List<Team> teams) {
        return false;
    }

    @Override
    public List<Game> filterByState(String state) {
        return null;
    }
}
