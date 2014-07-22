package com.hashedin.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hashedin.model.Project;
import com.hashedin.service.ProjectService;


@Component
@Path("/projects")
public class ProjectResource
{

    @Autowired
    private ProjectService projectService;

    private final String resourceURI = "/projects";

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Project> list(@DefaultValue("0") @QueryParam("offset") int offset, @DefaultValue("20") @QueryParam("limit") int limit)
    {
        // Handles GET on /projects. Lists all the projects we have in our system.
        return projectService.paginate(offset, limit);
    }


    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Path("/{projectId}")
    public Project get(@PathParam("projectId") Long projectId)
    {
        // Handles GET on /projects/{projectId}. Returns a single project for the given projectId.
        return projectService.find(projectId);
    }


    @POST
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response create(Project project) throws URISyntaxException
    {
        // Handles POST on /projects. Creates a new project and adds it into an repository.
        projectService.save(project);
        return Response.created(new URI(resourceURI + project.getId())).build();
    }


    @PUT
    @Path("/{projectId}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Project update(Project project, @PathParam("projectId") Long projectId)
    {
        // Handles PUT on /projects/projectId. Updates the existing project with the new values.
        return projectService.update(project, projectId);
    }


    @DELETE
    @Path("/{projectId}")
    public Project delete(@PathParam("projectId") Long projectId)
    {
        // Handles DELETE on /projects/projectId. Deletes the existing project and returns the same.
        return projectService.delete(projectId);
    }
}
