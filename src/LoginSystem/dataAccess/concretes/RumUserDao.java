package LoginSystem.dataAccess.concretes;

import LoginSystem.dataAccess.abstracts.UserDao;
import LoginSystem.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class RumUserDao implements UserDao {
    List<User> users;

    @Override
    public void add(User user) {
    users.add(user);
    }

    @Override
    public void update(User user) {
       for (User u :users){
           if (u.getId()==user.getId()){
               u.setFirstName(user.getFirstName());
               u.setLastName(user.getLastName());
               u.setEmail(user.getEmail());
               u.setPassword(user.getPassword());
               
           }
       }
    }

    @Override
    public void delete(User user) {
  users.remove(user);
    }

    @Override
    public List<User> getAll() {
        return users;
    }
}
