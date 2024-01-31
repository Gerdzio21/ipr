package pl.edu.pw.mchtr.ipr.user;


import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SessionController {

    boolean logout();
    void deleteAccount();
    void updateInfo(String name, String newName, Date c) throws Exception;
    void updateDescription(String description);
    void updatePhoto();
    List<String> searchUser(String name);
    Map<String, String> getInfo(String userName);
    List<String> filterByMatch (String userName , List<String> listNames);
    Map<String, String> getNameCountryBirth(Map<String, String> userData);
}
