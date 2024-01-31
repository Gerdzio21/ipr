package pl.edu.pw.mchtr.ipr.user;

import java.util.List;
import java.util.Map;

public class UserFetcher {
    private static UserFetcher instance;
    private UserFetcher(){

    }

    public static UserFetcher getInstance(){
        if (instance == null) {
            instance = new UserFetcher();
        }
        return instance;
    }

    public User getUser(String name){
        return null;
    }
    //TODO
    public Map<String, String> getUserData(){
        return null;
    }
    public List<User> getUsers(){
        return null;
    }
}
