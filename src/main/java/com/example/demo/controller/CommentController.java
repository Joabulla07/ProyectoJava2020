package com.example.demo.controller;


import com.example.demo.entity.Comment;
import com.example.demo.load.ApiResponse;
import com.example.demo.repository.CommentRepository;
import com.example.demo.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getAllComments(@PathVariable(name = "postId") Long postId) {
        List<Comment> allComments = commentService.getAllComments(postId);
        return allComments;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Comment> addComment(@RequestBody Comment newComment,
                                              @PathVariable(name = "postId") Long postId,
                                              @PathVariable(name = "userId") Long userId) {
        Comment newComm = commentService.addComment(newComment, postId, userId);

        return new ResponseEntity<>(newComm, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comment> getComment(@PathVariable(name = "postId") Long postId,
                                              @PathVariable(name = "id") Long id) {
        Comment comment = commentService.getComment(postId, id);

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Comment> updateComment(@PathVariable(name = "postId") Long postId,
                                                 @PathVariable(name = "id") Long id,@RequestBody Comment comment) {

        Comment updatedComment = commentService.updateComment(postId, id, comment);

        return new ResponseEntity<>(updatedComment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable(name = "postId") Long postId,
                                                     @PathVariable(name = "id") Long id, Long userId) {

        ApiResponse response = commentService.deleteComment(postId, id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
