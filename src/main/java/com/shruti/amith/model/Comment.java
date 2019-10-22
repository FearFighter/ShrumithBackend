package com.shruti.amith.model;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name="name")
    String name;

    @Column(name="subject")
    String subject;

    @Column(name="description", columnDefinition = "TEXT")
    String description;

    @Column(name="created_at")
    String createdAt = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss").print(new DateTime());

    public Comment() {
        super();
    }

    public Comment(String name, String subject, String description) {
        this.name = name;
        this.subject = subject;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
