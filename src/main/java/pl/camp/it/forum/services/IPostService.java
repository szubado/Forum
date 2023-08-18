package pl.camp.it.forum.services;

import pl.camp.it.forum.model.Post;
import pl.camp.it.forum.model.Topic;

import java.util.List;

public interface IPostService {
    public List<Post> getPostbyTopicId(int topicId);
    /*List<Post> getAllPosts();*/
    public void persistPost(Post post, int id);
}
