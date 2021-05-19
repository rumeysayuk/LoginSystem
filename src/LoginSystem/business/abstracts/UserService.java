package LoginSystem.business.abstracts;

import LoginSystem.entities.concretes.User;

import java.util.List;

public interface UserService {
    void login(String email,String password);
    void register(User user);
    void registerWithGoogle(String email,String password);

}
