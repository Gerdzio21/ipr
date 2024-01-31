package pl.edu.pw.mchtr.ipr.game;

public class PlayersPoints {

    private final String userName;
    private final int points;

    PlayersPoints (String userName){
        this(userName,0);
    }

    PlayersPoints (String userName, int startPoints){
        this.userName = userName;
        points = startPoints;
    }

    public int getPoints(){
        return 0;
    }
    public void addPoints(int value) {

    }
    public void updatePoints(int value) {

    }

}
