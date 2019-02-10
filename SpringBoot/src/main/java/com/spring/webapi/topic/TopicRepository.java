package com.spring.webapi.topic;

import com.spring.webapi.models.Course;
import com.spring.webapi.models.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

}
