package LoginSystem;

import LoginSystem.business.concretes.UserManager;
import LoginSystem.business.validationRules.UserValidator;
import LoginSystem.core.concretes.GoogleManager;
import LoginSystem.dataAccess.concretes.RumUserDao;
import LoginSystem.entities.concretes.User;

public class Main {

    public static void main(String[] args) {
        User user1=new User(1,"Rumedsf","Yük","rumeysayuk90@gmail.com","12365456");
        User user2=new User(1,"Rabia","Asdf","rabia123@gmail.com","67890967");
        User user3=new User(1,"Rabia","Asdf","rabia123@gmail.com","67890967");
        GoogleManager googleManager=new GoogleManager(new UserValidator());
        UserManager userManager=new UserManager(new RumUserDao(),new UserValidator());
        System.out.println("Register");
        googleManager.accountVerification(user1);
        googleManager.verifyAccount(user1);
        userManager.register(user1);
        googleManager.accountVerification(user2);
        googleManager.verifyAccount(user2);
        userManager.register(user2);
        googleManager.accountVerification(user3);
        googleManager.verifyAccount(user3);
        userManager.register(user3);
        System.out.println("Register with Google account");
        userManager.registerWithGoogle("rumeysa@rumeysa.com","123454354");
        userManager.registerWithGoogle("asd@asd.com","546576778");
        System.out.println("Login");
        userManager.login("rumeysayuk90@gmail.com","12365456");
        userManager.login("rabia123@gmail.com","67890967");
        userManager.login("rabia123@gmail.com","67890967");






    }
}