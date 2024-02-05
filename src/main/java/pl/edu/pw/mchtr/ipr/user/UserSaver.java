package pl.edu.pw.mchtr.ipr.user;

public class UserSaver {
    private static UserSaver instance;
    private UserSaver(){

    }

    public static UserSaver getInstance(){
        if (instance == null) {
            instance = new UserSaver();
        }
        return instance;
    }
    public void saveUser(User user){
        if(UserRepository.exist(user)){
            UserRepository.updateUser(user);
        }else {
            UserRepository.addUser(user);
        }
    }

}
