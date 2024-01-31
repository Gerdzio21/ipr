package pl.edu.pw.mchtr.ipr.game;

import java.util.List;

public interface GameController {

    List<String> getArchiveGames(String user);

    List<Ranking> getRankings();

    List<String> getActiveGames();

    Game startGame(String name);

    String tryGame(String name);

    String joinTeam(String name, String team);

    String checkGameType(Game game);

    boolean teamExist(String name, List<Team> teams);

    List<Game> filterByState(String state);
}
