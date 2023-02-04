package com.cnu.devblog.controller;

import com.cnu.devblog.entity.Post;
import com.cnu.devblog.model.request.PageRequest;
import com.cnu.devblog.model.request.PostRequest;
import com.cnu.devblog.model.type.Tag;
import com.cnu.devblog.repository.PostSpecification;
import com.cnu.devblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostRequest postRequest) {
        return ResponseEntity.ok(postService.createPost(postRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPost(@PathVariable Integer id) {
        return postService.getPost(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @GetMapping
    public ResponseEntity<Page<Post>> getPosts(PageRequest pageRequest,
                                               @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                               @RequestParam(value = "endDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
                                               @RequestParam(value = "tag", required = false) Tag tag) {
        Specification<Post> spec = (root, query, criteriaBuilder) -> null;

        if (startDate != null) {
            spec = spec.and(
                    PostSpecification
                            .greaterThanOrEqualTo(LocalDateTime.of(startDate, LocalDateTime.MIN.toLocalTime()))
            );
        }
        if (endDate != null) {
            spec = spec.and(
                    PostSpecification
                            .lessThanOrEqualTo(LocalDateTime.of(endDate, LocalDateTime.MAX.toLocalTime()))
            );
        }
        if (tag != null) {
            spec = spec.and(
                    PostSpecification
                            .equalTo(tag)
            );
        }

        return ResponseEntity.ok(postService.getPosts(spec, pageRequest.of()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody PostRequest postRequest) {
        return ResponseEntity.ok(postService.updatePost(id, postRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
