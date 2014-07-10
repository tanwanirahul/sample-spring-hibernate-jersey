package com.hashedin.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hashedin.model.Project;


@Repository("projectRepository")
public class ProjectRepositoryImpl implements ProjectRepository
{

    @PersistenceContext
    private EntityManager em;


    public Project find(Long projectId)
    {
        // Returns the Project for given projectId.
        return em.find(Project.class, projectId);
    }


    public Project save(Project project)
    {
        // Saves the given project object and returns the same.
        em.persist(project);
        em.flush();
        return project;
    }


    @Override
    public List<Project> findAll()
    {
        // Returns all the projects in our system.
        TypedQuery<Project> query = em.createNamedQuery("Project.findAll", Project.class);
        return query.getResultList();
    }


    @Override
    public List<Project> paginate(int offset, int limit)
    {
        // Returns the list of paginated projects.
        TypedQuery<Project> query = em.createNamedQuery("Project.findAll", Project.class);
        return query.setFirstResult(offset).setMaxResults(limit).getResultList();
    }


    @Override
    public Project update(Project project, Long projectId)
    {
        // Updates the given project with new data.
        project.setId(projectId);
        Project updatedProject = em.merge(project);
        em.flush();
        return updatedProject;
    }


    @Override
    public Project delete(Long projectId)
    {
        // Deletes the project with the given projectId.
        Project projectToBeDeleted = em.find(Project.class, projectId);
        em.remove(projectToBeDeleted);
        return projectToBeDeleted;
    }

}
