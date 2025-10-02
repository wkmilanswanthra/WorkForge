package com.workforge.project.web.dto;

import jakarta.validation.constraints.Size;

public class UpdateProjectRequest {
  @Size(max = 140)
  public String name;

  @Size(max = 5_000)
  public String description;
}
