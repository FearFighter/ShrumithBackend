package com.shruti.amith.validation;

import com.shruti.amith.model.Comment;

public class CommentValidation {

    public static boolean validateRequest(Comment comment){
        if(comment.getSubject() == null || comment.getSubject().isEmpty()) return false;
        return true;
    }
}
