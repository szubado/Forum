package pl.camp.it.forum.services;

import pl.camp.it.forum.model.Topic;

import java.util.List;

public interface ITopicService {
    List<Topic> getAllTopics();
    List<Topic> getFilteredTopics(String pattern);
    void persistTopic (Topic topic);
    void deleteTopic (int id);
    List<Topic> getTopicByTopicId(int topicId);
}
