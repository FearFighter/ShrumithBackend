package com.shruti.amith.validation;

import com.shruti.amith.model.Comment;

public class CommentValidation {

    public static boolean validateRequest(Comment comment){
        if(comment.getName() == null) return false;
        if(comment.getDescription() == null) return false;
        if(comment.getSubject() == null) return false;
        return true;
    }
}
