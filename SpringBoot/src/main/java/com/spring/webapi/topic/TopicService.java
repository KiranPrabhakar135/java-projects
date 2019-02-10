package com.spring.webapi.topic;

import com.spring.webapi.models.Course;
import com.spring.webapi.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getTopics(){
        List<Topic> courses = new ArrayList<>();
        topicRepository.findAll().forEach(course -> courses.add(course));
        return courses;
    }

    public void addTopic(Topic course){
        topicRepository.save(course);
    }

    public void updateTopic(Topic course, int id){
        if(topicRepository.findById(id) != null){
            topicRepository.save(course);
        }
    }

    public void deleteTopic(int id){
        topicRepository.deleteById(id);
    }

}
