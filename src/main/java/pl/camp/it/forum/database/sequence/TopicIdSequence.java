package pl.camp.it.forum.database.sequence;

import org.springframework.stereotype.Component;
@Component
public class TopicIdSequence implements ITopicIdSequence{
    private int id = 0;
    @Override
    public int getId() {
        return ++id;
    }
}
