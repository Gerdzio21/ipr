package pl.edu.pw.mchtr.ipr.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static pl.edu.pw.mchtr.ipr.game.GameType.*;

public class TrySelectedGameTest {

    private GameController gameController;
    @Mock
    private GameService gameServiceMock;

    @BeforeEach
    void setup(){
        gameServiceMock = mock(GameService.class);
        gameController = new UserGameController(gameServiceMock);
    }

    @Test
    void returnIndividualGameWhenGameIsIndividual(){
        //given
        when(gameServiceMock.getGame("test")).thenReturn(new GameIndividuals());
        //when
        String gameType = gameController.tryGame("test");
        //then
        verify(gameServiceMock).getGame("test");
        Assertions.assertEquals(gameType, IndividualGame.toString());
    }
    @Test
    void returnTeamGameWhenGameIsTeams(){
        //given
        when(gameServiceMock.getGame("test")).thenReturn(new GameTeams());
        //when
        String gameType = gameController.tryGame("test");
        //then
        Assertions.assertEquals(gameType, TeamGame.toString());
    }
}
