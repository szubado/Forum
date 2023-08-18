package pl.camp.it.forum.database.sequence;

import org.springframework.stereotype.Component;


public class UserIdSequence implements IUserIdSequence{
    private int id = 0;
    @Override
    public int getId() {
        return ++id;
    }
}
