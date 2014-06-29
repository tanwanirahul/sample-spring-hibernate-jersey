package com.hashedin.repository;

import com.hashedin.model.Task;

public interface TaskRepository {

    Task find(Long taskId);
    Task save(Task task);
    
}
