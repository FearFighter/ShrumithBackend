package main.shruthi.amith.service;

import main.shruthi.amith.dao.CommentDao;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private CommentDao commentDao;

    @Transactional
    public List<Comment> getAllComments() {
        return commentDao.getAllComments();
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
        commentDao.addComment(comment);
    }

    @Transactional
    public void updateComment(Comment comment) { commentDao.updateComment(comment); }

    @Transactional
    public void deleteComment(int id) {
        commentDao.deleteComment(id);
    }

    @Transactional
    public void deleteCommentByName(String name) {
        commentDao.deleteCommentByName(name);
    }
}
