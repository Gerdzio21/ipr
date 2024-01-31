package pl.edu.pw.mchtr.ipr.game;

import java.util.List;

import static pl.edu.pw.mchtr.ipr.game.GameType.*;

public class UserGameController implements GameController{

    private static GameService gameService;

    public UserGameController(){
        gameService = GameService.getInstance();
    }

    protected UserGameController(GameService gameService) {
        UserGameController.gameService = gameService;
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


        return null;
    }

    @Override
    public String checkGameType(Game game) {
        if(game instanceof GameTeams){
            return TeamGame.toString();
        }else if(game instanceof GameIndividuals){
            return IndividualGame.toString();
        }else{
            throw new RuntimeException("Unknown Game Type");
        }
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
