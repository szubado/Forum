package pl.camp.it.forum.database;

import pl.camp.it.forum.model.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> getByLogin(String login);
    Optional<User> getById(int id);
    void persistUser(User user);

}
