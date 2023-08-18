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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


/*public class TopicDAO implements ITopicDAO {
    private final List<Topic> topics = new ArrayList<>();
    ITopicIdSequence topicIdSequence;
   @Resource
    SessionData sessionData;
   @Autowired
    IPostService postService;


   *//* public TopicDAO(@Autowired ITopicIdSequence topicIdSequence) {
        topics.add(new Topic(topicIdSequence.getId(),"Uprawa pomidorów","Janusz Rolnik", 3, LocalDateTime.now()));
        topics.add(new Topic(topicIdSequence.getId(),"Jak szczotkować krowy","Mariusz Mleczarz", 0,LocalDateTime.now()));
        topics.add(new Topic(topicIdSequence.getId(),"Jak wyjąć drzazgę z palca","Dorotka123", 1,LocalDateTime.now()));
        topics.add(new Topic(topicIdSequence.getId(),"Jak wybrać naczepę do ciągnika","Pan Rolnik", 4,LocalDateTime.now()));
        this.topicIdSequence = topicIdSequence;
    }*//*

    @Override
    public List<Topic> getAllTopics() {
        //kopia listy, wszystkie elementy w glownej zostaja przerzucone do nowej listy
        return new ArrayList<>(this.topics);
    }

  *//*  @Override
    public void persistTopic(Topic topic) {
        topic.setId(this.topicIdSequence.getId());
        topic.setAuthor(sessionData.createAuthor());
        topic.setDateTime(LocalDateTime.now());
*//**//*
        topic.setQuantity(postService.getPostbyTopicId(topic.getId()).size());
*//**//*
        this.topics.add(topic);
    }*//*

    @Override
    public Optional<Topic> getTopicById(final int id) {
        return this.topics.stream().filter(t -> t.getId() == id).findFirst();
*//*        for (Topic topic : this.topics) {
            if (topic.getId() == id) {
                return Optional.of(topic);
            }
        }
        return Optional.empty();*//*
    }

    @Override
    public void deleteTopic(final int id) {
        Optional<Topic> topicBox = this.topics.stream().filter(t -> t.getId() == id).findFirst();
        topicBox.ifPresent(this.topics::remove);
        *//*Iterator<Topic> iterator = this.topics.iterator();
        while (iterator.hasNext()) {
            if(iterator.next().getId() == id) {
                iterator.remove();
                return;
            }
        }*//*
    }
}*/
