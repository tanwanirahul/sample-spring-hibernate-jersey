package com.hashedin.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.hashedin.model.Task;

@Repository("taskRepository")
public class TaskRepositoryImpl implements TaskRepository{

    @PersistenceContext
    private EntityManager em;
    
    public Task find(Long taskId) {
        // Returns the Task for given taskId.
        return em.find(Task.class, taskId);
    }

    public Task save(Task task) {
        // Saves the given task object and returns the same.
        em.persist(task);
        em.flush();
        return task;
    }

}
