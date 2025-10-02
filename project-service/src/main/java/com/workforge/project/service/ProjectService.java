package com.workforge.project.service;

import com.workforge.project.web.dto.CreateProjectRequest;
import com.workforge.project.web.dto.ProjectResponse;
import com.workforge.project.web.dto.UpdateProjectRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProjectService {
  ProjectResponse create(CreateProjectRequest req);
  ProjectResponse get(UUID id);
  Page<ProjectResponse> list(Pageable pageable);
  ProjectResponse update(UUID id, UpdateProjectRequest req);
  void delete(UUID id);
}
