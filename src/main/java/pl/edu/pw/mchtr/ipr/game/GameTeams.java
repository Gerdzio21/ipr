package pl.edu.pw.mchtr.ipr.game;

import pl.edu.pw.mchtr.ipr.user.User;

import java.util.ArrayList;
import java.util.List;

public class GameTeams extends Game {

    private final List<Team> teams;

    GameTeams() {
        super(1);
        teams = new ArrayList<>();
    }

    @Override
    public void addToGame() {

    }

    public void addToGame(String userName, Team team) {
        team.addParticipant(new User()); // TODO here should be user injected in constructor
        playersPoints.add(new PlayersPoints(userName));
    }

    public void addToGame(String userName, String teamName) {
        teams.add(new Team(teamName));
        playersPoints.add(new PlayersPoints(userName));
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addPoints(Team team, int value) {

    }

    public void alterPoints(Team team, int value) {

    }
}
