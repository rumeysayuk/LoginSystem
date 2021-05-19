package LoginSystem.business.validationRules;

import LoginSystem.entities.concretes.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    List<User> users;

    public boolean isValid(User user) {
        if (user.getFirstName().length() > 2 && user.getLastName().length() > 2 && user.getPassword().length() >= 6
                && !user.getEmail().isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean emailExist(String email) {
        boolean alreadyExists = true;

        for (User user : users) {
            if (user.getEmail() == email) {
                alreadyExists = false;
                break;
            }
        }
        return alreadyExists;
    }

    public boolean isValidEmail(String email){
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("foobar@gmail.com");
        return matcher.find(email);
    }
}
