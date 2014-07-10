package com.hashedin.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.hashedin.model.Task;


@Repository("taskRepository")
public class TaskRepositoryImpl implements TaskRepository
{

    @PersistenceContext
    private EntityManager em;


    public Task find(Long taskId)
    {
        // Returns the Task for given taskId.
        return em.find(Task.class, taskId);
    }


    public Task save(Task task)
    {
        // Saves the given task object and returns the same.
        em.persist(task);
        em.flush();
        return task;
    }


    @Override
    public List<Task> findAll()
    {
        // Returns all the tasks in our system.
        TypedQuery<Task> query = em.createNamedQuery("Task.findAll", Task.class);
        return query.getResultList();
    }


    @Override
    public List<Task> paginate(int offset, int limit)
    {
        // Returns the list of paginated tasks.
        TypedQuery<Task> query = em.createNamedQuery("Task.findAll", Task.class);
        return query.setFirstResult(offset).setMaxResults(limit).getResultList();
    }


    @Override
    public Task update(Task task, Long taskId)
    {
        // Updates the given task with new data.
        task.setId(taskId);
        Task updatedTask = em.merge(task);
        em.flush();
        return updatedTask;
    }


    @Override
    public Task delete(Long taskId)
    {
        // Deletes the task with the given taskId.
        Task taskToBeDeleted = em.find(Task.class, taskId);
        em.remove(taskToBeDeleted);
        return taskToBeDeleted;
    }

}
