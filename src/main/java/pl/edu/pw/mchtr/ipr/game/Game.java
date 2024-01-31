package pl.edu.pw.mchtr.ipr.game;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public abstract class Game {
    GameState state;
    String code;
    File video;
    List<String> players;
    List<PlayersPoints> playersPoints;
    GamePattern gamePattern;

    Game(int id){
        playersPoints = new ArrayList<PlayersPoints>();

    }
    public List<String> getUsers() {
        return null;
    }
    public abstract void addToGame();
    public void addPoints(PlayersPoints playersPoints, int value) {
    }
    public void updateState(GameState newState){

    }
    public void alterPoints(PlayersPoints playerPoints, int value){

    }
    public void start(){

    }
}
