package com.shruti.amith.controller;

import com.shruti.amith.service.CommentService;
import com.shruti.amith.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comments/all", method = RequestMethod.GET)
    public ResponseEntity<List<Comment>> getAllComments(){

        return ResponseEntity.ok().body(commentService.getAllComments());
    }

    @RequestMapping(value = "/comments/{name}", method = RequestMethod.GET)
    public ResponseEntity<Comment> getCommentByName(@PathVariable String name){

        return ResponseEntity.ok().body(commentService.getCommentByName(name));
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST, headers = "Accept=application/json")
    public ResponseEntity<String> addComment(@RequestBody Comment comment){
        Comment existingComment = commentService.getCommentByName(comment.getName());
        if(existingComment == null) {
            commentService.addComment(comment);
        } else {
            commentService.updateComment(comment);
        }
        return ResponseEntity.ok().header("Content-Type","application/text").body("Comment added successfully");
    }

    @RequestMapping(value = "/comments/delete/{name}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable("name") String name) {

        commentService.deleteCommentByName(name);
    }
}
