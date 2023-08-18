package pl.camp.it.forum.database;

import pl.camp.it.forum.model.Post;

import java.util.List;

public interface IPostDAO {
    void persist(Post post, int id);
    List<Post> getPostByTopicId(int topicId);

}
