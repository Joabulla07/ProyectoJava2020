package com.example.demo.services;


import com.example.demo.entity.Posts;
import com.example.demo.load.ApiResponse;
import com.example.demo.entity.User;
import org.springframework.web.servlet.function.EntityResponse;

public interface UserService  {

    User addUser(User user);

    User updateUser(User newUser, Long id);

    ApiResponse deleteUser(Long id);



}
