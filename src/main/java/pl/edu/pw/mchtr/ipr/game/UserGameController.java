package pl.edu.pw.mchtr.ipr.game;

import java.util.List;

import static pl.edu.pw.mchtr.ipr.game.GameType.*;
import static pl.edu.pw.mchtr.ipr.game.JoinStatus.*;

public class UserGameController implements GameController {

    private static GameService gameService;
    private static RankingService rankingService;
    private final UsersGames usersGames;
    // TODO here should be user injected in constructor

    public UserGameController() {
        this(GameService.getInstance(), RankingService.getInstance());
    }

    protected UserGameController(GameService gameService, RankingService rankingService) {
        UserGameController.gameService = gameService;
        UserGameController.rankingService = rankingService;
        usersGames = new UsersGames(gameService.getOpenGames(), rankingService.getAllRankings());
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
        Game selectedGame = gameService.getGame(name);
        return checkGameType(selectedGame);
    }

    @Override
    public String joinTeam(String teamName, String gameId) {
        Game game = gameService.getGame(gameId);
        if(!(game instanceof GameTeams)) {
            throw new RuntimeException("Game is not team game");
        }
        GameTeams gameTeams = (GameTeams) game;
        List<Team> teams = gameTeams.getTeams();
        usersGames.addGame(gameTeams);
        if(teamExist(teamName, teams)) {
            gameTeams.addToGame("userName", teams.get(0));
            return addedToTeam.toString();
        } else {
            gameTeams.addToGame("userName", "teamName");
            return addedNewTeam.toString();
        }

    }

    @Override
    public String checkGameType(Game game) {
        if (game instanceof GameTeams) {
            return TeamGame.toString();
        } else if (game instanceof GameIndividuals) {
            return IndividualGame.toString();
        } else {
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
