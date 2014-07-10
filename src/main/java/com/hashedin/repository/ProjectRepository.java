package com.hashedin.repository;

import java.util.List;

import com.hashedin.model.Project;

public interface ProjectRepository {

    Project find(Long projectId);
    List<Project> findAll();
    List<Project> paginate(int offset, int limit);
    Project save(Project Project);
    Project update(Project Project, Long projectId);
    Project delete(Long projectId);

}
