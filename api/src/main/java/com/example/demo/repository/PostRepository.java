package com.example.demo.repository;

import com.example.demo.entity.Posts;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Posts, Long> {
}
