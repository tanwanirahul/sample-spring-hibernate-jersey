package com.hashedin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.model.Project;
import com.hashedin.repository.ProjectRepository;


@Service("projectService")
public class ProjectServiceImpl implements ProjectService
{

    @Autowired
    private ProjectRepository projectRepository;


    public Project find(Long projectId)
    {
        // Returns the Project for given projectId.
        return projectRepository.find(projectId);
    }


    @Transactional
    public Project save(Project project)
    {
        // Saves the given project object and returns the same.
        projectRepository.save(project);
        return project;
    }


    @Override
    public List<Project> findAll()
    {
        // Returns all the projects in our system.
        return projectRepository.findAll();
    }


    @Transactional
    public Project update(Project project, Long projectId)
    {
        // Updates the project with the given projectId;
        return projectRepository.update(project, projectId);
    }


    @Transactional
    public Project delete(Long projectId)
    {
        // Deletes the project with the give projectId and returns the same.
        return projectRepository.delete(projectId);
    }


    @Override
    public List<Project> paginate(int offset, int limit)
    {
        // Paginates the projects objects. 
        return projectRepository.paginate(offset, limit);
    }

}
