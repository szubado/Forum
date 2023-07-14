package pl.camp.it.forum.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.forum.model.Post;
import pl.camp.it.forum.model.Topic;
import pl.camp.it.forum.services.IPostService;
import pl.camp.it.forum.services.ITopicService;
import pl.camp.it.forum.session.SessionData;

import java.util.List;

@Controller
@RequestMapping(path = "/topic")
public class PostController {
    @Autowired
    private IPostService postService;
    @Autowired
    ITopicService topicService;
    @Resource
    SessionData sessionData;

    @RequestMapping(path = "/read/{id}", method = RequestMethod.GET)
    public String readTopic(Model model, @PathVariable int id) {
        List<Topic> topics = this.topicService.getTopicByTopicId(id);
        List<Post> posts = this.postService.getPostbyTopicId(id);
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("postModel", new Post());
        model.addAttribute("posts", posts);
        model.addAttribute("topicById", topics);
        return "read-post";
    }

    @RequestMapping(path = "/read/{id}", method = RequestMethod.POST)
    public String addPost(@ModelAttribute Post post, @PathVariable int id) {
        if (!this.sessionData.isLogged()) {
            return "redirect:/main";
        }
            this.postService.persistPost(post, id);
        System.out.println(post);
        return "redirect:/topic/read/"+id;
    }
}
