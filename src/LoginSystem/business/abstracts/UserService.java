package LoginSystem.business.abstracts;

import LoginSystem.entities.concretes.User;

public interface UserService {
    void login(String email,String password);
    void register(User user);
    void registerWithGoogle(String email,String password);
}
