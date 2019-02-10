package com.spring.webapi.topic;
import com.spring.webapi.models.Course;
import com.spring.webapi.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping("/topic")
    public List<Topic> getTopics(){
        return topicService.getTopics();
    }
    @RequestMapping("/topic/{topicId}")
    public Topic getTopics(@PathVariable("topicId") int id){ // maps topicId to id
        return topicService.getTopics().stream().filter(course -> course.getId() == id).findFirst().get();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/topic")
    public void addTopic(@RequestBody Topic course){
        topicService.addTopic(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/topic/{id}")
    public void updateTopic(@RequestBody Topic course, @PathVariable int id){
        topicService.updateTopic(course, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/topic")
    public void deleteTopic(@PathVariable int id){
        topicService.deleteTopic(id);
    }
}
