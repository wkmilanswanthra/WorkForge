package com.workforge.project.repo;

import com.workforge.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProjectRepository extends JpaRepository<Project, UUID> {
  boolean existsByNameIgnoreCase(String name);
}
