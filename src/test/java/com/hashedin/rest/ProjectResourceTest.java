package com.hashedin.rest;


import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hashedin.model.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:jpaContext.xml")
@ActiveProfiles("test")
@Transactional
public class ProjectResourceTest {

	@Autowired
	private ProjectResource resource;

	
	@Test
	public void testGetAllProjects() throws URISyntaxException {
		List<Project> projects = resource.list(0, 0);
		assertEquals(projects.size(), 0);
		
		Project p = new Project();
		p.setName("Buddha Smiles Again");
		p.setDescription("So what if he smiles");
		
		resource.create(p);
		
		assertEquals(resource.list(0, 0).size(), 1);
		
	}
	
	
}
