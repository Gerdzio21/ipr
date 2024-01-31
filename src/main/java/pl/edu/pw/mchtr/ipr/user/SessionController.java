package pl.edu.pw.mchtr.ipr.user;


import java.util.Date;
import java.util.List;
import java.util.Map;

public interface SessionController {

    boolean logout();
    void deleteAccount();
    boolean updateInfo(String a, String b, Date c);
    void updateDescription(String description);
    void updatePhoto();
    List<User> searchUser(String name);
    Map<String, String> getInfo(String a);
    List<String> filterByMatch (String a , List<String> b);
    Map<String, String> getNameCountryBirth(Map<String, String> a);
}
