package org.shruti.amith.dao;

import org.shruti.amith.model.Comment;

import java.util.List;

public interface CommentDao {
    public List<Comment> getAllComments() ;

    public Comment getComment(Integer id) ;

    public Comment getCommentByName(String name) ;

    public Comment addComment(Comment comment);

    public void updateComment(Comment comment) ;

    public void deleteComment(Integer id) ;

    public void deleteCommentByName(String name) ;
}
