package pl.camp.it.forum.database.memory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.forum.database.IUserRepository;
import pl.camp.it.forum.database.sequence.IUserIdSequence;
import pl.camp.it.forum.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



/*public class UserDAO implements IUserRepository {
    private final List<User> users = new ArrayList<>();
    IUserIdSequence userIdSequence;
    public UserDAO(@Autowired IUserIdSequence userIdSequence) {
        this.users.add(new User(userIdSequence.getId(),"admin","21232f297a57a5a743894a0e4a801fc3",
                "Ania","Kowalska","akow@op.pl", User.Role.ADMIN));
        this.users.add(new User(userIdSequence.getId(),"janusz","087d9c5e13bdd64a82bef8e013625c32",
                "Janusz","Kuc","jakuc@wp.pl", User.Role.USER));
        this.userIdSequence = userIdSequence;
    }

    @Override
    public Optional<User> getByLogin(final String login) {
        return this.users.stream().filter(u -> u.getLogin().equals(login)).findFirst().map(User::copyOfUser);
*//*        for (User user : this.users) {
            if(user.getLogin().equals(login)) {
                return Optional.of(User.copyOfUser(user));
            }
        }
        return Optional.empty();*//*
    }

    @Override
    public void persistUser(User user) {
        user.setId(this.userIdSequence.getId());
        this.users.add(user);
    }
}*/
