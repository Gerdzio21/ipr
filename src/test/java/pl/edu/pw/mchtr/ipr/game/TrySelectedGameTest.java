package pl.edu.pw.mchtr.ipr.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static pl.edu.pw.mchtr.ipr.game.GameType.*;

public class TrySelectedGameTest {

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
    void returnIndividualGameWhenGameIsIndividual() {
        //given
        when(gameServiceMock.getGame("test")).thenReturn(new GameIndividuals());
        //when
        String gameType = gameController.tryGame("test");
        //then
        verify(gameServiceMock).getGame("test");
        assertEquals(gameType, IndividualGame.toString());
    }

    @Test
    void returnTeamGameWhenGameIsTeams() {
        //given
        when(gameServiceMock.getGame("test")).thenReturn(new GameTeams());
        //when
        String gameType = gameController.tryGame("test");
        //then
        verify(gameServiceMock).getGame("test");
        assertEquals(gameType, TeamGame.toString());
    }

    @Test
    void shouldThrowExceptionWhenGameIsNotTeamsOrIndividuals() {
        //given
        when(gameServiceMock.getGame("test")).thenReturn(null);
        //when & then
        assertThrows(RuntimeException.class, () -> {
            gameController.tryGame("test");
        });
    }
}
