package LoginSystem.business.validationRules;

import LoginSystem.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    List<User> users = new ArrayList<User>();

    public void fillUsers() {
        users.add(new User(1, "emircan", "dalman", "emircan1@gmail.com", "1234567"));
        users.add(new User(1, "emircan2", "dalman", "emircan2@gmail.com", "1234567"));
        users.add(new User(1, "emircan3", "dalman", "emircan3@gmail.com", "1234567"));
        users.add(new User(1, "emircan4", "dalman", "emircan4@gmail.com", "1234567"));
        users.add(new User(1, "emircan5", "dalman", "emircan5@gmail.com", "1234567"));
    }

    public boolean isValid(User user) {
        boolean result = false;
        if (user.getFirstName().length() > 2 && user.getLastName().length() > 2 && user.getPassword().length() >= 6
                && !user.getEmail().isEmpty()) {
            result = true;
        }
        return result;
    }

    public boolean emailExist(String email) {
        fillUsers();
        boolean alreadyExists = false;
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                alreadyExists = true;
                break;
            }
        }
        return alreadyExists;
    }

    public boolean isValidEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
