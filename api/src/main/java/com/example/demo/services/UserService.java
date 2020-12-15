package com.example.demo.services;


import com.example.demo.apiresponse.ApiResponse;
import com.example.demo.entity.User;

public interface UserService  {

    User addUser(User user);

    User updateUser(User newUser, Long id);

    ApiResponse deleteUser(Long id);

}
