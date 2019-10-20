package main.shruthi.amith.controller;

import main.shruthi.amith.service.CommentService;
import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/comments/all", method = RequestMethod.GET)
    public List<Comment> getAllComments(){

        return commentService.getAllComments();
    }

    @RequestMapping(value = "/comments/{name}", method = RequestMethod.GET)
    public Comment getCommentByName(@PathVariable String name){

        return commentService.getCommentByName(name);
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST, headers = "Accept=application/json")
    public void addComment(@ModelAttribute("comment") Comment comment){

        if(comment.getName() == null) {
            commentService.addComment(comment);
        } else {
            commentService.updateComment(comment);
        }
    }

    @RequestMapping(value = "/comments/delete/{name}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable("name") String name) {

        commentService.deleteCommentByName(name);
    }
}
