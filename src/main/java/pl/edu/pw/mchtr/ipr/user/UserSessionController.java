package pl.edu.pw.mchtr.ipr.user;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class UserSessionController implements SessionController{
    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public void deleteAccount() {

    }

    @Override
    public boolean updateInfo(String a, String b, Date c) {
        return false;
    }

    @Override
    public void updateDescription(String description) {

    }

    @Override
    public void updatePhoto() {

    }

    @Override
    public List<User> searchUser(String name) {
        return null;
    }

    // TODO
    @Override
    public Map<String, String> getInfo(String a) {
        return null;
    }

    @Override
    public List<String> filterByMatch(String a, List<String> b) {
        return null;
    }

    @Override
    public Map<String, String> getNameCountryBirth(Map<String, String> a) {
        return null;
    }
}
