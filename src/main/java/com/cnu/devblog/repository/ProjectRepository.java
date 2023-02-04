package com.cnu.devblog.repository;

import com.cnu.devblog.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>, JpaSpecificationExecutor<Project> {
    Page<Project> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end, Pageable pageable);
}