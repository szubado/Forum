package pl.camp.it.forum.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.forum.database.ITopicDAO;
import pl.camp.it.forum.model.Topic;
import pl.camp.it.forum.services.ITopicService;
import java.util.ArrayList;
import java.util.List;
@Service
public class TopicServiceImpl implements ITopicService {

    @Autowired
    private ITopicDAO topicDAO;
    @Override
    public List<Topic> getAllTopics() {
        return this.topicDAO.getAllTopics();
    }

    @Override
    public List<Topic> getFilteredTopics(String pattern) {
        List<Topic> topics = getAllTopics();
        List<Topic> filtered = new ArrayList<>();
        for (Topic topic : topics) {
            if (topic.getTitle().toLowerCase().contains(pattern.toLowerCase()) ||
                    topic.getAuthor().toLowerCase().contains(pattern.toLowerCase())) {
                filtered.add(topic);
            }
        }
        return filtered;
    }

    @Override
    public void persistTopic(Topic topic) {
        this.topicDAO.persistTopic(topic);
    }

    @Override
    public void deleteTopic(int id) {
        this.topicDAO.deleteTopic(id);
    }
    @Override
    public List<Topic> getTopicByTopicId(int topicId) {
        List<Topic> topics = getAllTopics();
        List<Topic> topicByTopicId = new ArrayList<>();
        for (Topic topic : topics) {
            if (topic.getId() == topicId) {
                topicByTopicId.add(topic);
            }
        }
        return topicByTopicId;
    }
}
