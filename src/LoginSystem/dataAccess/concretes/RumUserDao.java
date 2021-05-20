package LoginSystem.dataAccess.concretes;

import LoginSystem.dataAccess.abstracts.UserDao;
import LoginSystem.entities.concretes.User;

import java.util.ArrayList;

public class RumUserDao implements UserDao {
    ArrayList<User> users = new ArrayList<>();

    public RumUserDao() {
        fillUsers();
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void update(User user) {
        for (User u : users) {
            if (u.getId() == user.getId()) {
                delete(u);
                add(user);
                System.out.println(user.getFirstName() + " isimli kullanıcı başarıyla güncellendi");
                return;
            }
        }
        System.out.println("Girilen Id ile eşleşen bir kullanıcı bulunamadı..");
    }

    @Override
    public void delete(User user) {
        for (User u : users) {
            if (u.getId() == user.getId()) {
                users.removeIf(us -> us.getId() == user.getId());
                System.out.println(user.getFirstName() + " isimli kullanıcı başarıyla silindi");
                break;
            }
        }
    }

    @Override
    public ArrayList<User> getAll() {
        return users;
    }

    private void fillUsers() {
        users.add(new User(1, "rumeysa", "yuk", "rumeysayuk90@gmail.com", "1234567"));
        users.add(new User(2, "rabia", "asd", "rabia123mailcom", "1234567"));
        users.add(new User(3, "rumeysa", "drfdrgv", "rumeysa@gmail.com", "1234567"));
        users.add(new User(4, "rabia", "asd", "rabia123@gmail.com", "1234567"));
        users.add(new User(5, "asd", "asd", "asd@asd.com", "1234567"));
    }
}
