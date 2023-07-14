package pl.camp.it.forum.database;

import pl.camp.it.forum.model.Topic;

import java.util.List;

public interface ITopicDAO {
    List<Topic> getAllTopics();
    void persistTopic(Topic topic); //posts
    Topic getTopicById(int id);
    void deleteTopic(int id);
}
