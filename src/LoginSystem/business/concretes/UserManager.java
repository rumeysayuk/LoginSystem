package LoginSystem.business.concretes;

import LoginSystem.business.abstracts.UserService;
import LoginSystem.business.validationRules.UserValidator;
import LoginSystem.dataAccess.abstracts.UserDao;
import LoginSystem.dataAccess.concretes.RumUserDao;
import LoginSystem.entities.concretes.User;

import java.util.ArrayList;
import java.util.List;

public class UserManager implements UserService {
    private UserDao userDao;
    UserValidator userValidator = new UserValidator(new RumUserDao());
    ArrayList<User> users;

    public UserManager(UserDao userDao) {
        this.userDao = userDao;
        users = this.userDao.getAll();
    }

    @Override
    public void login(String email, String password) {
        for (User u : users){
            if (u.getEmail().equals(email) && u.getPassword().equals(password)){
                System.out.println("Giriş Başarılı");
            }else{
                System.out.println("Bilgileriniz Hatalı");
            }
        }
    }

    @Override
    public void register(User user) {
        if (userValidator.isValid(user) && !userValidator.emailExist(user.getEmail()) && userValidator.isValidEmail(user.getEmail())) {
            System.out.println(user.getFirstName() + " " + user.getLastName() + " kullanici kaydı başarılı ");
        } else if (userValidator.emailExist(user.getEmail())) {
            System.out.println(" Bu mail adresi kullanılıyor!!");
        } else if (!userValidator.isValid(user)) {
            System.out.println(" Eksik karakter girdiniz kayıt yapılamadı!!");
        } else if (!userValidator.isValidEmail(user.getEmail())) {
            System.out.println(" Bu mail adresi geçersiz");
        } else {
            System.out.println("Şuanda Bir hata oluştu. lütfen daha sonra tekrar deneyiniz..");
        }
    }

    @Override
    public void registerWithGoogle(String email, String password) {
        if (userValidator.isValidEmail(email) && password.length() >= 6) {
            System.out.println(email + " adresi ile kayıt olundu");
        } else {
            System.out.println(email + " google kaydı başarısız");
        }
    }

    @Override
    public void add(User user) {
        if (userValidator.isValid(user)){
            this.userDao.add(user);
        }else{
            System.out.println("Validasyon Hatası");
        }
    }

    @Override
    public void update(User user) {
        if (userValidator.isValid(user)){
            this.userDao.update(user);
        }else{
            System.out.println("Validasyon Hatası");
        }
    }

    @Override
    public void delete(User user) {
        this.userDao.delete(user);
    }

    @Override
    public ArrayList<User> getAll() {
        return users;
    }
}