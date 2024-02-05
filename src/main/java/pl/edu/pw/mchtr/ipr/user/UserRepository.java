package pl.edu.pw.mchtr.ipr.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private final static List<User> users = new ArrayList<>();

    public static void addUser(User user){
        users.add(user);
    }
    public static List<User> getUsers(){
        return users;
    }
    public static Optional<User> getUserByName(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .findFirst();
    }

    public static boolean exist(User user) {
        return users.stream()
                .anyMatch(existingUser -> existingUser.getName().equals(user.getName()));
    }

    public static void updateUser(User newUser) {
        users.stream()
                .filter(existingUser -> existingUser.getName().equals(newUser.getName()))
                .findFirst()
                .ifPresent(existingUser -> {
                    existingUser.setName(newUser.getName());
                    existingUser.setCountry(newUser.getCountry());
                    existingUser.setBirthDate(newUser.getBirthDate());
                });
    }
}
