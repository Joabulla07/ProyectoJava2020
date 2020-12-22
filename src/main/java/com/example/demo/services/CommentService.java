package com.example.demo.services;

import com.example.demo.entity.Comment;
import com.example.demo.load.ApiResponse;

import java.util.List;

public interface CommentService {

    Comment addComment(Comment comment, Long postId, Long userId);

    Comment getComment(Long postId, Long id);

    Comment updateComment(Long postId, Long id, Comment newComm);

    ApiResponse deleteComment(Long postId, Long id);

    List<Comment> getAllComments(Long postId);

}
