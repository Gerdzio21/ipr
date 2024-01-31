package pl.edu.pw.mchtr.ipr.game;

import java.util.List;

public final class RankingService {
    private static RankingService instance;

    private RankingService() {

    }

    public static RankingService getInstance() {
        if (instance == null) {
            instance = new RankingService();
        }
        return instance;
    }

    public void update() {

    }

    public Ranking getRanking() {
        return null;
    }

    public List<Ranking> getAllRankings() {
        return null;
    }
}
