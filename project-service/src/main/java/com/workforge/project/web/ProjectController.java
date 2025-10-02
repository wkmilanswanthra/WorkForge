package com.workforge.project.web;

import com.workforge.project.service.ProjectService;
import com.workforge.project.web.dto.CreateProjectRequest;
import com.workforge.project.web.dto.ProjectResponse;
import com.workforge.project.web.dto.UpdateProjectRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService service;

    public ProjectController(ProjectService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResponse create(@Valid @RequestBody CreateProjectRequest req) {
        return service.create(req);
    }

    @GetMapping("/{id}")
    public ProjectResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    @GetMapping
    public Page<ProjectResponse> list(Pageable pageable) {
        return service.list(pageable);
    }

    @PatchMapping("/{id}")
    public ProjectResponse update(@PathVariable UUID id,
            @Valid @RequestBody UpdateProjectRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
