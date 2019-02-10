package com.spring.webapi.topics.course;

import com.spring.webapi.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getCourses(int topicId){
        return courseRepository.findByTopicId(topicId);
    }

    public Course getCourse(int topicId, int courseId){
        return courseRepository.findByTopicId(topicId).stream().filter(course -> course.getId() == courseId).findFirst().get();
    }
    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Course course, int id){
        if(courseRepository.findById(id) != null){
            courseRepository.save(course);
        }
    }

    public void deleteTopic(int id){
        courseRepository.deleteById(id);
    }

}
