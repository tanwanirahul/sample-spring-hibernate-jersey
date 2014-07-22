package com.hashedin.repository;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.model.Project;
import com.hashedin.model.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:jpaContext.xml")
@ActiveProfiles("test")
@Transactional
public class ProjectRepositoryTest {

	private static final long FOUNDERS_DAY = 1414800000; //1st November 2014
	private static final long TWO_DAYS = 2 * 24 * 60 * 60 * 1000;
	
	@Autowired
	private ProjectRepository repository;
	
	@Test
	public void testCreateProject() {
		
		List<Project> projects = repository.findAll();
		assertEquals(0, projects.size());
		
		Project p = createProject();
		Long id = p.getId();
		
		assertEquals(1, repository.findAll().size());
		
		Project savedProj = repository.find(id);
		assertEquals(savedProj.getName(), p.getName());
		assertEquals(savedProj.getDescription(), p.getDescription());
		
	}
	
	@Test
	public void testTaskCreationWithoutAnAssignee() {
		Project p = createProject();
		long id = p.getId();
		
		Task task = new Task();
		task.setTitle("Plan a Party");
		task.setCreationDate(new Date(FOUNDERS_DAY - TWO_DAYS));
		task.setExpectedEndDate(new Date(FOUNDERS_DAY));
		
		Set<Task> tasks = new HashSet<Task>();
		tasks.add(task);
		
		p.setTasks(tasks);
		repository.save(p);
		
		Project savedProject = repository.find(id);
		assertEquals(savedProject.getTasks().size(), 1);
		Task savedTask = savedProject.getTasks().iterator().next();
		assertEquals(savedTask.getCreationDate(), new Date(FOUNDERS_DAY - TWO_DAYS));
		assertEquals(savedTask.getExpectedEndDate(), new Date(FOUNDERS_DAY));
		assertNull(savedTask.getAssignee());
	}
	
	
	private Project createProject() {
		Project p = new Project();
		p.setName("Buddha Smiles Again");
		p.setDescription("Launch Nuclear Bomb");
		p = repository.save(p);
		return p;
	}

}
