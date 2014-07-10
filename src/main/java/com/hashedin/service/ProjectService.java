package com.hashedin.service;

import java.util.List;

import com.hashedin.model.Project;

public interface ProjectService {

    Project find(Long projectId);
    List<Project> findAll();
    List<Project> paginate(int offset, int limit);
    Project save(Project project);
    Project update(Project project, Long projectId);
    Project delete(Long projectId);
}
