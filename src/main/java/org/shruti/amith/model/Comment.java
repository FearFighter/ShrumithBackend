package org.shruti.amith.model;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name="COMMENT")
public class Comment{

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name="name")
    String name;

    @Column(name="description")
    String description;

    @Column(name="created_at")
    String createdAt = new DateTime().toString();

    public Comment() {
        super();
    }

    public Comment(String name, String description) {
        super();
        this.name = name;
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
}
