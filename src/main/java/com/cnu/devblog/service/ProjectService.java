package com.cnu.devblog.service;

import com.cnu.devblog.entity.Post;
import com.cnu.devblog.entity.Project;
import com.cnu.devblog.model.request.PostRequest;
import com.cnu.devblog.model.request.ProjectRequest;
import com.cnu.devblog.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    public Project createProject(ProjectRequest projectRequest) {
        return projectRepository.save(projectRequest.toEntity());
    }

    public Optional<Project> getProject(Integer id) {
        return projectRepository.findById(id);
    }

    public Project updateProject(Integer id, ProjectRequest projectRequest) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()); //FIXME: ERROR_CODE 정의하기
        project.setTitle(projectRequest.getTitle());
        project.setSummary(projectRequest.getSummary());
        project.setDescription(projectRequest.getDescription());
        project.setStartDate(projectRequest.getStartDate());
        project.setEndDate(projectRequest.getEndDate());
        project.setIsInProgress(projectRequest.getIsInProgress());
        return projectRepository.save(project);
    }

    public void deleteProject(Integer id) {
        projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException()); //FIXME: ERROR_CODE 정의하기
        projectRepository.deleteById(id);
    }

    public Page<Project> getProjects(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }
}
