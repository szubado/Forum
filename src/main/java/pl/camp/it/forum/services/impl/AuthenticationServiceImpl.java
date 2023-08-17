package pl.camp.it.forum.services.impl;

import jakarta.annotation.Resource;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.forum.database.IUserRepository;
import pl.camp.it.forum.exceptions.LoginAlreadyExists;
import pl.camp.it.forum.model.User;
import pl.camp.it.forum.services.IAuthenticationService;
import pl.camp.it.forum.session.SessionData;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
    @Autowired
    IUserRepository userRepository;
    @Resource
    SessionData sessionData;
    @Override
    public void authenticate(String login, String password) {
        Optional<User> userBox = this.userRepository.getByLogin(login);
        if(userBox.isPresent() && userBox.get().getPassword().equals(DigestUtils.md5Hex(password))) {
            userBox.get().setPassword(null);
            this.sessionData.setUser(userBox.get());
        }
    }

    @Override
    public void logout() {
        //na biekcie danej sesji ustawiamy logged
        this.sessionData.setUser(null);
    }

    @Override
    public void register(User user) throws LoginAlreadyExists {
        if (this.userRepository.getByLogin(user.getLogin()).isPresent()) {
            throw new LoginAlreadyExists();
        }
        user.setPassword(DigestUtils.md5Hex((user.getPassword())));
        this.userRepository.persistUser(user);
    }

}
