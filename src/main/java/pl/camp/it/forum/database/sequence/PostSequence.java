package pl.camp.it.forum.database.sequence;

import org.springframework.stereotype.Component;

@Component
public class PostSequence implements IPostSequence{
    private int id = 0;
    @Override
    public int getId() {
        return ++id;
    }
}
