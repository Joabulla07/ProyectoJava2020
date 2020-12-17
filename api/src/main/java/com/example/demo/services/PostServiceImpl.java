package com.example.demo.services;

import com.example.demo.load.ApiResponse;
import com.example.demo.entity.Posts;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.PostRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository PostRepository;

    @Autowired
    private UserRepository UserRepository;


    @Override
    public Posts addPost(Posts posts, Long id) {
        User user = UserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        posts.setTitle(posts.getTitle());
        posts.setBody(posts.getBody());
        posts.setUser(user);
        posts.setPublished(true);
        return PostRepository.save(posts);
    }

    @Override
    public Posts updatePost(Posts newPost, Long id) {
        Posts post = PostRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("POST", "ID", id));
        post.setTitle(newPost.getTitle());
        post.setBody(newPost.getBody());
        post.setPublished(true);
            return PostRepository.save(post);

    }

    @Override
    public ApiResponse deletePost(Long id) {
        Posts post = PostRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("POST", "ID", id));
            PostRepository.deleteById(id);
            return new ApiResponse(Boolean.TRUE, "You successfully deleted post");
    }

}
