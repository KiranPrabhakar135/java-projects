package com.spring.webapi.topics.course;
import com.spring.webapi.models.Course;
import com.spring.webapi.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping("topic/{id}/course")
    public List<Course> getCourses(@PathVariable int id){
        return courseService.getCourses(id);
    }

    @RequestMapping("topic/{id}/course/{courseId}")
    public Course getCourse(@PathVariable int id, @PathVariable int courseId){ // maps topicId to id
        return courseService.getCourses(id).stream().filter(course -> course.getId() == courseId).findFirst().get();
    }

    @RequestMapping(method = RequestMethod.POST, value = "topic/{topicId}/course")
    public void addTopic(@PathVariable int topicId, @RequestBody Course course){
        course.setTopic(new Topic(topicId, "",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "topic/{topicId}/course/{id}")
    public void updateTopic(@RequestBody Course course, @PathVariable int topicId, @PathVariable int id){
        course.setTopic(new Topic(topicId, "",""));
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/course/{id}")
    public void deleteTopic(@PathVariable int id){
        courseService.deleteTopic(id);
    }
}
