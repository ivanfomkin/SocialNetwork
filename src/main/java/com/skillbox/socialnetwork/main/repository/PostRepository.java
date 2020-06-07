package com.skillbox.socialnetwork.main.repository;

import com.skillbox.socialnetwork.main.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    Page<Post> findAllPosts(String text, LocalDate dateFrom, LocalDate dateTo, Pageable pageable);

    Post findPostById(Integer id);
}
