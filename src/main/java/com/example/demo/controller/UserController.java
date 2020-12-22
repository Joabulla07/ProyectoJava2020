package com.example.demo.controller;

import com.example.demo.load.ApiResponse;
import com.example.demo.services.UserService;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserRepository UserRepository;

    @Autowired
    private UserService userService;



    @PostMapping("/userAdd")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);

        return new ResponseEntity< >(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User newUser,
                                           @PathVariable(value = "id") Long id) {
        User updatedUSer = userService.updateUser(newUser, id);

        return new ResponseEntity< >(updatedUSer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable(value = "id") Long id) {
        ApiResponse apiResponse = userService.deleteUser(id);
        return new ResponseEntity< >(apiResponse, HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return UserRepository.findAll();
    }

    @GetMapping("/{ciudad}")
    public List<User> getAllUsersCiudad(@PathVariable(value = "ciudad") String ciudad){
        return UserRepository.findAllByCiudad(ciudad);
    }

    @GetMapping("/lista/{fecha}")
    public List<User> getUserFromDate(@PathVariable(value = "fecha")
                                                          @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date){
        return UserRepository.findUserByFechaAltaIsAfter(date);
    }

}
