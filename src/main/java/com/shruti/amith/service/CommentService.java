package com.shruti.amith.service;

import com.shruti.amith.dao.CommentDao;
import com.shruti.amith.model.Comment;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Transactional
    public List<Comment> getAllComments() {

        List<Comment> comments = commentDao.getAllComments();
        comments.sort(Comparator.comparing(o -> o.getUpdatedAt()));
        return comments.size() > 6 ? comments.subList(comments.size() - 6, comments.size()) : comments;
    }

    @Transactional
    public Comment getComment(Integer id) {
        return commentDao.getComment(id);
    }

    @Transactional
    public Comment getCommentByName(String name) {
        return commentDao.getCommentByName(name);
    }

    @Transactional
    public void addComment(Comment comment) {
        if(comment.getName().isEmpty()){
            comment.setName("Anonymous");
        }
        comment.setUpdatedAt(DateTimeFormat.forPattern("yyyy MMM dd hh:mm:ss").print(new DateTime()));
        commentDao.addComment(comment);
    }

    @Transactional
    public void updateComment(Comment existingComment, Comment comment) {
        existingComment.setUpdatedAt(DateTimeFormat.forPattern("yyyy MMM dd hh:mm:ss").print(new DateTime()));
        existingComment.setSubject(comment.getSubject());
        existingComment.setDescription(comment.getDescription());
        commentDao.updateComment(existingComment);
    }

    @Transactional
    public void deleteComment(int id) {
        commentDao.deleteComment(id);
    }

    @Transactional
    public void deleteCommentByName(String name) {
        commentDao.deleteCommentByName(name);
    }
}
