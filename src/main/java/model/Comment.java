package model;

import org.joda.time.DateTime;

import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public Integer id;

    @Column(name="name")
    public String name;

    @Column(name="description")
    public String description;

    @Column(name="created_at")
    public String createdAt = new DateTime().toString();

    public Comment() {
        super();
    }

    public Comment(Integer id, String name, String description, String createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdAt = createdAt;
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
