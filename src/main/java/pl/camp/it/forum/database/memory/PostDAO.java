package pl.camp.it.forum.database.memory;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.camp.it.forum.database.IPostDAO;
import pl.camp.it.forum.database.sequence.IPostSequence;
import pl.camp.it.forum.database.sequence.ITopicIdSequence;
import pl.camp.it.forum.model.Post;
import pl.camp.it.forum.model.Topic;
import pl.camp.it.forum.session.SessionData;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDAO implements IPostDAO {
    private final List<Post> posts = new ArrayList<>();
    @Resource
    SessionData sessionData;
    IPostSequence postSequence;
    public PostDAO(@Autowired IPostSequence postSequence) {
        posts.add(new Post(postSequence.getId(), "tekst", "Jan", 4, LocalDateTime.now()));
        posts.add(new Post(postSequence.getId(), "tekst", "Ben",4,LocalDateTime.now()));
        posts.add(new Post(postSequence.getId(), "tekst", "Ania",3, LocalDateTime.now()));
        posts.add(new Post(postSequence.getId(), "tekst", "Buła",4, LocalDateTime.now()));
        posts.add(new Post(postSequence.getId(), "tekst", "Ed",1, LocalDateTime.now()));
        posts.add(new Post(postSequence.getId(), "tekst", "Maja",1, LocalDateTime.now()));
        posts.add(new Post(postSequence.getId(), "tekst", "Wąs",1, LocalDateTime.now()));
        posts.add(new Post(postSequence.getId(), "tekst", "Kuc",1, LocalDateTime.now()));
        this.postSequence = postSequence;
    }

    @Override
    public void persistTopic(Post post, int id) {
        post.setId(this.postSequence.getId());
        post.setAuthor(sessionData.createAuthor());
        post.setTopicId(id);
        post.setDateTime(LocalDateTime.now());
        this.posts.add(post);
    }

    @Override
    public List<Post> getAllPosts() {
        return new ArrayList<>(this.posts);
    }
}
