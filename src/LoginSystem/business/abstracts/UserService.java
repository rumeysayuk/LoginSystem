package LoginSystem.business.abstracts;

import LoginSystem.entities.concretes.User;

import java.util.ArrayList;

public interface UserService {
    void login(String email,String password);
    void register(User user);
    void registerWithGoogle(String email,String password);
    void add(User user);
    void update(User user);
    void delete(User user);
    ArrayList<User> getAll();
}
