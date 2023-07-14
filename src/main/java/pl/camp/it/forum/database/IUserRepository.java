package pl.camp.it.forum.database;

import pl.camp.it.forum.model.User;

public interface IUserRepository {
    User getByLogin(String login);
    void persistUser(User user);
}
