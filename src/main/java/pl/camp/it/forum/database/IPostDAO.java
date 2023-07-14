package pl.camp.it.forum.database;

import pl.camp.it.forum.model.Post;
import pl.camp.it.forum.model.Topic;

import java.util.List;

public interface IPostDAO {
    void persistTopic(Post post, int id); //posts
    List<Post> getAllPosts();
}
