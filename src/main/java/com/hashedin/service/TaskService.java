package com.hashedin.service;

import java.util.List;

import com.hashedin.model.Task;

public interface TaskService {

    Task find(Long taskId);
    List<Task> findAll();
    Task save(Task task);
    Task update(Task task, Long taskId);
    Task delete(Long taskId);
}
