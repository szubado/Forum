package pl.camp.it.forum.services;

import pl.camp.it.forum.exceptions.LoginAlreadyExists;
import pl.camp.it.forum.model.User;

public interface IAuthenticationService {

    void authenticate(String login, String password);
    void logout();
    void register(User user) throws LoginAlreadyExists;
}
