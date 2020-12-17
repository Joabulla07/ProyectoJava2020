package com.example.demo.services;

import com.example.demo.load.ApiResponse;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User newUser, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
            user.setNombre(newUser.getNombre());
            user.setApellido(newUser.getApellido());
            user.setMail(newUser.getMail());
            user.setPassword(newUser.getPassword());
            user.setCiudad(newUser.getCiudad());
            user.setProvincia(newUser.getProvincia());
            user.setPais(newUser.getPais());
            return userRepository.save(user);
    }

    @Override
    public ApiResponse deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepository.deleteById(user.getId());
        return new ApiResponse(Boolean.TRUE, "You successfully deleted profile of: " + id);
    }


}
