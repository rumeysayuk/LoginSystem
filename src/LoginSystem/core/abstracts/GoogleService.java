package LoginSystem.core.abstracts;

import LoginSystem.entities.concretes.User;

public interface GoogleService {
    void verifyAccount(User user);
    void accountVerification(User user);

}
