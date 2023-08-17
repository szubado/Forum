package pl.camp.it.forum.database;

import pl.camp.it.forum.model.Topic;

import java.util.List;
import java.util.Optional;

public interface ITopicDAO {
    List<Topic> getAllTopics();
    void persistTopic(Topic topic); //posts
    Optional<Topic> getTopicById(int id);
    void deleteTopic(int id);
}
