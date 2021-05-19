package LoginSystem.core.concretes;

import LoginSystem.business.validationRules.UserValidator;
import LoginSystem.core.abstracts.GoogleService;
import LoginSystem.entities.concretes.User;

public class GoogleManager implements GoogleService {
    UserValidator userValidator;

    public GoogleManager(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    @Override
    public void verifyAccount(User user) {
        if(userValidator.isValid(user)){
            System.out.println("Sayın "+user.getFirstName()+" "+user.getLastName() +"Google hesabınız doğrulandı.");
        }
        else{
            System.out.println("google doğrulaması başarısız");
        }
    }
    public void accountVerification(User user){
        if(userValidator.isValid(user)){
            System.out.println(user.geteMail()+ "adresine doğrulama kodu gönderildi.");
        }
    }
}
