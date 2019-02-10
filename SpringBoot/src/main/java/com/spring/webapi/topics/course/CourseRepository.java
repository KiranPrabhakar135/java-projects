package com.spring.webapi.topics.course;

import com.spring.webapi.models.Course;
import com.spring.webapi.models.Topic;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
//    public List<Course> findByName(String name);
//    public List<Course> findByDescription(String description);
    public List<Course> findByTopicId(int topicId);

}
