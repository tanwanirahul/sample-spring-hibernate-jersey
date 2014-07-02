package com.hashedin.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.model.Task;
import com.hashedin.service.TaskService;


@Component
@Path("/tasks")
public class TaskResource
{

    @Autowired
    private TaskService taskService;


    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Task> list()
    {
        return taskService.findAll();
    }


    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/{taskId}")
    public Task get(@PathParam("taskId") Long taskId)
    {
        return taskService.find(taskId);
    }
}
