package com.workforge.project.mapper;

import com.workforge.project.domain.Project;
import com.workforge.project.web.dto.CreateProjectRequest;
import com.workforge.project.web.dto.ProjectResponse;
import com.workforge.project.web.dto.UpdateProjectRequest;

public final class ProjectMapper {
  private ProjectMapper() {}

  public static Project toEntity(CreateProjectRequest req) {
    var p = new Project();
    p.setName(req.name);
    p.setDescription(req.description);
    return p;
  }

  public static void update(Project p, UpdateProjectRequest req) {
    if (req.name != null) p.setName(req.name);
    if (req.description != null) p.setDescription(req.description);
  }

  public static ProjectResponse toResponse(Project p) {
    return new ProjectResponse(
        p.getId(),
        p.getName(),
        p.getDescription(),
        p.getCreatedAt(),
        p.getUpdatedAt()
    );
  }
}
