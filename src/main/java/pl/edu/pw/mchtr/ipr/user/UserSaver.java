package pl.edu.pw.mchtr.ipr.user;

public class UserSaver {
    private static UserSaver instance;
    private UserSaver(){

    };
    public static UserSaver getInstance(){
        if (instance == null) {
            instance = new UserSaver();
        }
        return instance;
    }
    void saveUser(User user){};

}
