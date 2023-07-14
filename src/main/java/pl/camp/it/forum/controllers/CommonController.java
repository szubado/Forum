package pl.camp.it.forum.controllers;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.camp.it.forum.services.ITopicService;
import pl.camp.it.forum.session.SessionData;

@Controller
public class CommonController {

    @Autowired
    private ITopicService topicService;
    @Resource
    SessionData sessionData;

    @GetMapping(path = {"/main", "/"})
    public String main(Model model) {
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        return "main";
    }
    @RequestMapping(path = "/topics", method = RequestMethod.GET)
    public String topics(Model model, @RequestParam(required = false) String pattern) {
        if (pattern == null) {
            model.addAttribute("topics", this.topicService.getAllTopics());
        } else {
            model.addAttribute("topics", this.topicService.getFilteredTopics(pattern));
        }
        ModelUtils.addCommonDataToModel(model, this.sessionData);
        return "topics";
    }
}
