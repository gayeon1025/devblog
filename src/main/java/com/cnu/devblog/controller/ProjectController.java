package com.cnu.devblog.controller;

import com.cnu.devblog.entity.Project;
import com.cnu.devblog.model.request.PageRequest;
import com.cnu.devblog.model.request.ProjectRequest;
import com.cnu.devblog.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> createPost(@RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.createProject(projectRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getPost(@PathVariable Integer id) {
        return projectService.getProject(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updatePost(@PathVariable Integer id, @RequestBody ProjectRequest projectRequest) {
        return ResponseEntity.ok(projectService.updateProject(id, projectRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<Project>> getPosts(PageRequest pageRequest) {
        return ResponseEntity.ok(projectService.getProjects(pageRequest.of()));
    }
}
