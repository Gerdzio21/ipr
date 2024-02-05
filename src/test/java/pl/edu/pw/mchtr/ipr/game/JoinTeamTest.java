package pl.edu.pw.mchtr.ipr.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static pl.edu.pw.mchtr.ipr.game.JoinStatus.*;

public class JoinTeamTest {

    @Mock
    private GameService gameServiceMock;
    @Mock
    private RankingService rankingServiceMock;

    private GameController gameController;

    @BeforeEach
    void setup() {
        gameServiceMock = mock(GameService.class);
        rankingServiceMock = mock(RankingService.class);
        gameController = new UserGameController(gameServiceMock, rankingServiceMock);
        when(rankingServiceMock.getAllRankings()).thenReturn(new ArrayList<Ranking>());
        when(gameServiceMock.getOpenGames()).thenReturn(new ArrayList<Game>());

    }

    @Test
    void shouldBeAddedToTeamWhenTeamExist() {
        //given
        when(gameServiceMock.getGame("test")).thenReturn(new GameTeams());
        //when
        String status = gameController.joinTeam("Bob", "Team");
        //then
        Assertions.assertEquals(status, addedToTeam.toString());
    }

    @Test
    void shouldBeAddedToNewTeamWhenTeamDoesNotExist() {
        //given
        when(gameServiceMock.getGame("test")).thenReturn(new GameTeams());
        //when
        String status = gameController.joinTeam("Bob", "Team");
        //then
        Assertions.assertEquals(status, addedNewTeam.toString());
    }

}
