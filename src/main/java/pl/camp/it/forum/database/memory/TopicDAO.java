package pl.camp.it.forum.database.memory;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.forum.database.ITopicDAO;
import pl.camp.it.forum.database.sequence.ITopicIdSequence;
import pl.camp.it.forum.model.Post;
import pl.camp.it.forum.model.Topic;
import pl.camp.it.forum.services.IPostService;
import pl.camp.it.forum.session.SessionData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class TopicDAO implements ITopicDAO {
    private final List<Topic> topics = new ArrayList<>();
    ITopicIdSequence topicIdSequence;
   @Resource
    SessionData sessionData;
   @Autowired
    IPostService postService;


    public TopicDAO(@Autowired ITopicIdSequence topicIdSequence) {
        topics.add(new Topic(topicIdSequence.getId(),"Uprawa pomidorów","Janusz Rolnik", 3));
        topics.add(new Topic(topicIdSequence.getId(),"Jak szczotkować krowy","Mariusz Mleczarz", 0));
        topics.add(new Topic(topicIdSequence.getId(),"Jak wyjąć drzazgę z palca","Dorotka123", 1));
        topics.add(new Topic(topicIdSequence.getId(),"Jak wybrać naczepę do ciągnika","Pan Rolnik", 4));
        this.topicIdSequence = topicIdSequence;
    }

    @Override
    public List<Topic> getAllTopics() {
        //kopia listy, wszystkie elementy w glownej zostaja przerzucone do nowej listy
        return new ArrayList<>(this.topics);
    }

    @Override
    public void persistTopic(Topic topic) {
        topic.setId(this.topicIdSequence.getId());
        topic.setAuthor(sessionData.createAuthor());
/*
        topic.setQuantity(postService.getPostbyTopicId(topic.getId()).size());
*/
        this.topics.add(topic);
    }

    @Override
    public Topic getTopicById(int id) {
        for (Topic topic : this.topics) {
            if (topic.getId() == id) {
                return topic;
            }
        }
        return null;
    }

    @Override
    public void deleteTopic(int id) {
        Iterator<Topic> iterator = this.topics.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().getId() == id) {
                iterator.remove();
                return;
            }
        }
    }
}
