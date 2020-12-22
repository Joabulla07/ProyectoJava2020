package com.example.demo.repository;

import com.example.demo.entity.Posts;
import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Posts, Long> {

    List<Posts> findPostsByTitleLike(String n);
    List<Posts> findPostsByisPublishedIsFalse();

}
