package LoginSystem.business.concretes;

import LoginSystem.business.abstracts.UserService;
import LoginSystem.business.validationRules.UserValidator;
import LoginSystem.dataAccess.abstracts.UserDao;
import LoginSystem.entities.concretes.User;

import java.util.List;

public class UserManager implements UserService {
private UserDao userDao;
    private UserValidator userValidator;
    public UserManager(UserDao userDao,UserValidator userValidator) {
        this.userDao = userDao;
        this.userValidator = userValidator;
    }


    @Override
    public void login(String email, String password) {
        if(userValidator.isValidEmail(email) && password.length()>=6){
            System.out.println(" Giris başarılı");
        }
        else {
            System.out.println("Giriş  başarısız");
        }
    }

    @Override
    public void register(User user) {
        if (userValidator.isValid(user) && !userValidator.emailExist(user.geteMail())){
            System.out.println(user.getFirstName() +" "+ user.getLastName()+ " kullanici kaydı başarılı ");
        }
        else if(userValidator.emailExist(user.geteMail())){
            System.out.println(" Bu mail adresi kullanılıyor!!");
        }
        else {
            System.out.println(" Eksik karakter girdiniz kayıt yapılamadı!!");
        }
    }

    @Override
    public void registerWithGoogle(String email, String password) {
           if(userValidator.isValidEmail(email) && password.length()>=6){
               System.out.println(email+ " adresi ile kayıt olundu");
           }
           else {
               System.out.println(email+ " google kaydı başarısız");
           }
    }


}
