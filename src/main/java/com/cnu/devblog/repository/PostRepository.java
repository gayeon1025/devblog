package com.cnu.devblog.repository;

import com.cnu.devblog.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>, JpaSpecificationExecutor<Post> {
    Page<Post> findByCreatedAtBetween(LocalDateTime createdAt, LocalDateTime createdAt2, Pageable pageable);
}
