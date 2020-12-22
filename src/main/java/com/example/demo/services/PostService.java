package com.example.demo.services;

import com.example.demo.load.ApiResponse;
import com.example.demo.entity.Posts;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.ArrayList;
import java.util.List;


public interface PostService {

    ApiResponse deletePost(Long id);

    Posts addPost(Posts post, Long user_id);

    Posts updatePost(Posts newPost, Long id);

}
