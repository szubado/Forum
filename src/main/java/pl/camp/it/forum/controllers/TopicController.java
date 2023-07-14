package pl.camp.it.forum.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.camp.it.forum.exceptions.TopicValidatorException;
import pl.camp.it.forum.model.Post;
import pl.camp.it.forum.model.Topic;
import pl.camp.it.forum.services.IPostService;
import pl.camp.it.forum.services.ITopicService;
import pl.camp.it.forum.session.SessionData;
import pl.camp.it.forum.validators.PostValidator;

@Controller
@RequestMapping(path = "/topic")
public class TopicController {
    @Autowired
    ITopicService topicService;
    @Autowired
    IPostService postService;

    @Resource
    SessionData sessionData;

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addTopic(Model model) {
        if (!this.sessionData.isLogged()) {
            return "redirect:/main";
        }
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        model.addAttribute("topicModel", new Topic());
        model.addAttribute("postModel", new Post());
        return "add-topic";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addTopic(@ModelAttribute Topic topic, @ModelAttribute Post post) {
        if (!this.sessionData.isLogged()) {
            return "redirect:/main";
        }
        try {
            PostValidator.validatePost(post.getText());
            this.topicService.persistTopic(topic);
            this.postService.persistPost(post, topic.getId());
        } catch (TopicValidatorException e) {
            return "redirect:/topic/add";

        }
        return "redirect:/topics";
    }

/*    @RequestMapping(path = "/update/{id}", method = RequestMethod.GET)
    public String updateTopic(@PathVariable int id) {
        if (!this.sessionData.isAdmin()) {
            return "redirect:/main";
        }
        return "";
    }*/

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTopic(@PathVariable int id) {
        if (!this.sessionData.isAdmin()) {
            return "redirect:/main";
        }
        this.topicService.deleteTopic(id);
        return "redirect:/topics";
    }

}
