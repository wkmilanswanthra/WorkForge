package com.workforge.project.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateProjectRequest {
  @NotBlank
  @Size(max = 140)
  public String name;

  @Size(max = 5_000)
  public String description;
}
