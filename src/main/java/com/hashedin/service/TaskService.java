package com.hashedin.service;

import com.hashedin.model.Task;

public interface TaskService {

    Task find(Long taskId);

    Task save(Task task);
}
