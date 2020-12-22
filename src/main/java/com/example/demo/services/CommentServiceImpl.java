package com.example.demo.services;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Posts;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.load.ApiResponse;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    private static final String ID_STR = "id";

    private static final String COMMENT_STR = "Comment";

    private static final String POST_STR = "Post";

    @Override
    public Comment addComment(Comment newComm, Long postId, Long userId) {
        Posts post = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_STR, ID_STR, postId));
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));;
        Comment comm = new Comment(newComm.getBody());
        comm.setUser(user);
        comm.setPost(post);
        comm.setAutorId(userId);
        return commentRepository.save(comm);
    }

    @Override
    public Comment updateComment(Long postId, Long id, Comment newComm) {
        postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_STR, ID_STR, postId));
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(COMMENT_STR, ID_STR, id));

            comment.setBody(newComm.getBody());
            return commentRepository.save(comment);
    }

    @Override
    public ApiResponse deleteComment(Long postId, Long id) {
        postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_STR, ID_STR, postId));
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(COMMENT_STR, ID_STR, id));
        commentRepository.deleteById(comment.getId());
        return new ApiResponse(Boolean.TRUE, "You successfully deleted comment");

    }

    @Override
    public Comment getComment(Long postId, Long id) {
        postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException(POST_STR, ID_STR, postId));
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(COMMENT_STR, ID_STR, id));

        return comment;
    }

    @Override
    public List<Comment> getAllComments(Long postId) {
        List<Comment> comment =  commentRepository.findByPostId(postId);
        return comment;
    }
}
