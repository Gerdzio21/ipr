package pl.edu.pw.mchtr.ipr.game;

import java.util.List;

public class UsersGames {

    private final List<Game> games;
    private final List<Ranking> rankings;
    UsersGames (List<Game> gamesList, List<Ranking>rankingsList) {
        games = gamesList;
        rankings = rankingsList;
    }
    public List<Game> getGames(){
        return games;
    }
    public List<Ranking> getRankings(){
        return rankings;
    }
    public void addGame(Game game){
        games.add(game);
    }
    public void addRanking(Ranking ranking){
        rankings.add(ranking);
    }
}
