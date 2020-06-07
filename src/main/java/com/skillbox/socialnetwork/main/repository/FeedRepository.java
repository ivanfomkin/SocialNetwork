package com.skillbox.socialnetwork.main.repository;

import com.skillbox.socialnetwork.main.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends JpaRepository<Post, Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM Posts post WHERE post.author_id IN (SELECT p.id FROM persons p" +
                    " JOIN friendships f ON p.id = f.dst_person_id JOIN friendship_statuses fs " +
                    "ON f.status_id = fs.id WHERE f.src_person_id = :id AND fs.code = 'FRIEND')" +
                    " AND post.title like concat('%', :name, '%') ORDER BY post.time DESC ")
    Page<Post> getAllPosts(@Param("id")Integer id,
                           @Param("name")String name,
                           Pageable pageable);
}
