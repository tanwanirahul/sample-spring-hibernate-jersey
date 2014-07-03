package com.hashedin.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        // Handles GET on /tasks. Lists all the tasks we have in our system.
        return taskService.findAll();
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/{taskId}")
    public Task get(@PathParam("taskId") Long taskId)
    {
        // Handles GET on /tasks/{taskId}. Returns a single task for the given taskId.
        return taskService.find(taskId);
    }

    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response create(Task task, @Context final HttpServletResponse response) throws URISyntaxException
    {
        // Handles POST on /tasks. Creates a new task and adds it into an repository.
        taskService.save(task);
        response.setStatus(Response.Status.CREATED.getStatusCode());
        return Response.created(new URI("/tasks/" + task.getId())).build();
    }
    
    @PUT
    @Path("/{taskId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Task update(Task task, @PathParam("taskId") Long taskId)
    {
        // Handles PUT on /tasks/taskId. Updates the existing task with the new values.
        return taskService.update(task, taskId);
    }
    
    @DELETE
    @Path("/{taskId}")
    public Task delete(@PathParam ("taskId") Long taskId)
    {
        // Handles DELETE on /tasks/taskId. Deletes the existing task and returns the same.
        return taskService.delete(taskId);
    }
}
