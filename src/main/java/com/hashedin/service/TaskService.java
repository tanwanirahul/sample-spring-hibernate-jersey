package com.hashedin.service;

import java.util.List;

import com.hashedin.model.Task;

public interface TaskService {

    Task find(Long taskId);
    List<Task> findAll();
    List<Task> paginate(int offset, int limit);
    Task save(Task task);
    Task update(Task task, Long taskId);
    Task delete(Long taskId);
}
