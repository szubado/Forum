package pl.camp.it.forum.services.impl;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.camp.it.forum.database.IPostDAO;
import pl.camp.it.forum.model.Post;
import pl.camp.it.forum.model.Topic;
import pl.camp.it.forum.services.IPostService;
import pl.camp.it.forum.session.SessionData;

import java.util.ArrayList;
import java.util.List;
@Service
public class PostServiceImpl implements IPostService {
    @Autowired
    IPostDAO postDAO;
    @Resource
    SessionData sessionData;

    @Override
    public List<Post> getPostbyTopicId(final int topicId) {
        return this.postDAO.getPostByTopicId(topicId);
        /*return posts.stream().filter(p -> p.getTopicId() == topicId).toList();*/
        /*List<Post> postByTopicId = new ArrayList<>();
        for (Post post : posts) {
            if (post.getTopicId() == topicId) {
                postByTopicId.add(post);
            }
        }
        return postByTopicId;*/
    }

   /* @Override
    public List<Post> getAllPosts() {
        return this.postDAO.getAllPosts();
    }*/
    @Override
    public void persistPost(Post post, int id) {
        post.setUser(sessionData.getUser());
        this.postDAO.persist(post, id);
    }
}
