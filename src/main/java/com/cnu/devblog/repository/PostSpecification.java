package com.cnu.devblog.repository;

import com.cnu.devblog.entity.Post;
import com.cnu.devblog.model.type.Tag;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PostSpecification {
    public static Specification<Post> greaterThanOrEqualTo(LocalDateTime startDate) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.greaterThanOrEqualTo(root.get("createdAt"), startDate);
        };
    }

    public static Specification<Post> lessThanOrEqualTo(LocalDateTime endDate) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.lessThanOrEqualTo(root.get("createdAt"), endDate);
        };
    }

    public static Specification<Post> equalTo(Tag tag) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("tag"), tag);
        };
    }
}
