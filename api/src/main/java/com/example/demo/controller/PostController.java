package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.load.ApiResponse;
import com.example.demo.entity.Posts;
import com.example.demo.repository.PostRepository;
import com.example.demo.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class PostController {

    @Autowired
    private PostService PostService;

    @Autowired
    private PostRepository PostRepository;


    @GetMapping("/posts/all")
    public List<Posts> getAllPosts(){
        return PostRepository.findAll();
    }

    @GetMapping("/posts/{word}")
    public List<Posts> getAllPostsByWord(@PathVariable(value = "word") String word){
        return PostRepository.findPostsByTitleLike(word);
    }

    @GetMapping("/posts/false")
    public List<Posts> getAllPostsFalse() {
        return PostRepository.findPostsByisPublishedIsFalse();
    }

    @PostMapping("/posts/{id}")
    public ResponseEntity<Posts> addPost(@RequestBody Posts post,
                                         @PathVariable(name = "id") Long id) {
        Posts newPost = PostService.addPost(post, id);
        return new ResponseEntity< >(newPost, HttpStatus.CREATED);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Posts> updatePost(@RequestBody Posts newPost,
                                            @PathVariable(name = "id") Long id) {
        Posts updatedPost = PostService.updatePost(newPost, id);

        return new ResponseEntity< >(updatedPost, HttpStatus.OK);
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable(name = "id") Long id) {
        ApiResponse apiResponse = PostService.deletePost(id);

        return new ResponseEntity< >(apiResponse, HttpStatus.OK);
    }




}
