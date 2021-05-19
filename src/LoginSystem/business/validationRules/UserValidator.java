package LoginSystem.business.validationRules;

import LoginSystem.entities.concretes.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    List<User> users;

    public boolean isValid(User user) {
        if (user.getFirstName().length() > 2 && user.getLastName().length() > 2 && user.getPassword().length() >= 6
                && !user.geteMail().isEmpty()) {

            return true;
        }
        return false;
    }

    public boolean emailExist(String email) {
        for (User user : users) {
            if (user.geteMail() == email) {
                return true;
            }
        }
        return false;
    }

    public boolean isValidEmail(String email){

        String regex = "^(.+)@(.+)$";

        Pattern pattern = Pattern.compile(regex);

        String[] emails = new String[0];
        for(String email1 : emails) {
            Matcher matcher = pattern.matcher(email1);
            System.out.println(email1 + " : " + matcher.matches());
        }
        return false;
    }

}
