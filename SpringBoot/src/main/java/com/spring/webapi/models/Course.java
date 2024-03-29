package com.spring.webapi.models;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    private int id;
    private String name;
    private String description;
    @ManyToOne
    private Topic topic;

    public Course() {
    }

    public Course(int id, String name, String description, int topicId) {
        this.id = id;
        this.name = name;
        this.description = description;
        topic = new Topic(topicId, "","");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic){
        this.topic = topic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
