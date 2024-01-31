package pl.edu.pw.mchtr.ipr.user;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserSessionController implements SessionController {

    private final User user;
    private static UserFetcher userFetcher;
    private static UserSaver userSaver;

    UserSessionController() {
        this(UserFetcher.getInstance(), UserSaver.getInstance());
    }

    UserSessionController(UserFetcher userFetcher, UserSaver userSaver) {
        UserSessionController.userFetcher = userFetcher;
        UserSessionController.userSaver = userSaver;
        user = new User();
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public void deleteAccount() {

    }

    @Override
    public void updateInfo(String currentName, String newName, Date c) throws Exception {
        List<User> listNames = userFetcher.getUsers();
        if (findName(listNames, newName)) {
            throw new Exception("Name is already taken");
        } else {
            User user = userFetcher.getUser(currentName);
            user.updateInfo(currentName, newName, Date.from(Instant.now()));
            userSaver.saveUser(user);
        }

    }

    public boolean findName(List<User> listNames, String name) {
        return listNames.stream()
                .anyMatch(user -> user.getName().equals(name));
    }

    @Override
    public void updateDescription(String description) {

    }

    @Override
    public void updatePhoto() {

    }

    @Override
    public List<String> searchUser(String name) {
        List<User> users = userFetcher.getUsers();
        List<String> listNames = users.stream().map(User::getName).toList();
        return filterByMatch(name, listNames);
    }

    @Override
    public Map<String, String> getInfo(String userName) {
        Map<String, String> userData = userFetcher.getUserData();
        return getNameCountryBirth(userData);
    }

    @Override
    public List<String> filterByMatch(String name, List<String> listNames) { //TODO nie moze byc private, bo metody w interfejsie zawsze sa publiczne
        return listNames.stream()
                .filter(currentName -> currentName.toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, String> getNameCountryBirth(Map<String, String> userData) {

        String[] selectedKeys = {"Name", "Country", "Birth"};

        return userData.entrySet().stream()
                .filter(entry -> containsKey(selectedKeys, entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static boolean containsKey(String[] array, String key) {
        for (String element : array) {
            if (element.equals(key)) {
                return true;
            }
        }
        return false;
    }
}
