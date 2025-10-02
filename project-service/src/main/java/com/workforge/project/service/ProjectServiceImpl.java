package com.workforge.project.service;

import com.workforge.project.domain.Project;
import com.workforge.project.mapper.ProjectMapper;
import com.workforge.project.repo.ProjectRepository;
import com.workforge.project.web.dto.CreateProjectRequest;
import com.workforge.project.web.dto.ProjectResponse;
import com.workforge.project.web.dto.UpdateProjectRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.workforge.project.mapper.ProjectMapper.toResponse;

import java.util.UUID;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

  private final ProjectRepository repo;

  public ProjectServiceImpl(ProjectRepository repo) {
    this.repo = repo;
  }

  @Override
  public ProjectResponse create(@Valid CreateProjectRequest req) {
    if (repo.existsByNameIgnoreCase(req.name)) {
      throw new IllegalArgumentException("Project name already exists");
    }
    Project saved = repo.save(ProjectMapper.toEntity(req));
    return toResponse(saved);
  }

  @Override
  @Transactional(readOnly = true)
  public ProjectResponse get(UUID id) {
    Project p = repo.findById(id).orElseThrow(() ->
        new EntityNotFoundException("Project not found: " + id));
    return toResponse(p);
  }

  @Override
  @Transactional(readOnly = true)
  public Page<ProjectResponse> list(Pageable pageable) {
    return repo.findAll(pageable).map(ProjectMapper::toResponse);
  }

  @Override
  public ProjectResponse update(UUID id, UpdateProjectRequest req) {
    Project p = repo.findById(id).orElseThrow(() ->
        new EntityNotFoundException("Project not found: " + id));
    ProjectMapper.update(p, req);
    return toResponse(p);
  }

  @Override
  public void delete(UUID id) {
    if (!repo.existsById(id)) throw new EntityNotFoundException("Project not found: " + id);
    repo.deleteById(id);
  }
}
