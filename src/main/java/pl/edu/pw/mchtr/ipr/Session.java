package pl.edu.pw.mchtr.ipr;

import pl.edu.pw.mchtr.ipr.game.GameController;
import pl.edu.pw.mchtr.ipr.store.StoreController;
import pl.edu.pw.mchtr.ipr.user.SessionController;

import java.util.UUID;

public class Session {
    private final UUID uid;
    private final SessionController sessionController;
    private final GameController gameController;
    private final StoreController storeController;

    public Session(UUID uid, SessionController sessionController, GameController gameController, StoreController storeController) {
        this.uid = uid;
        this.sessionController = sessionController;
        this.gameController = gameController;
        this.storeController = storeController;
    }

    public SessionController getSessionController() {
        return sessionController;
    }

    public GameController getGameController() {
        return gameController;
    }

    public StoreController getStoreController() {
        return storeController;
    }
}
