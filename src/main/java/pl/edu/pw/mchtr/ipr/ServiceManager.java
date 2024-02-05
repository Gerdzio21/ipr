package pl.edu.pw.mchtr.ipr;

import pl.edu.pw.mchtr.ipr.game.UserGameController;
import pl.edu.pw.mchtr.ipr.store.StoreService;
import pl.edu.pw.mchtr.ipr.store.UsersStoreController;
import pl.edu.pw.mchtr.ipr.user.SessionController;
import pl.edu.pw.mchtr.ipr.user.UserSessionController;

import java.util.*;

public class ServiceManager {

    private static ServiceManager instance;
    private final Map<String,Session> sessions;

    private ServiceManager() {
        sessions = new HashMap();
    }

    public static ServiceManager getInstance() {
        if (instance == null) {
            instance = new ServiceManager();
        }
        return instance;
    }

    public void update(){

    }
    public void createNewSession(String userName){
        sessions.computeIfAbsent(userName, k-> new Session(UUID.randomUUID(), new UserSessionController(), new UserGameController(), new UsersStoreController()));
    }
    public void endSession(String userName){
        sessions.remove(userName);
    }
    public Session getUserSession(String userName){
        return sessions.get(userName);
    }
}
