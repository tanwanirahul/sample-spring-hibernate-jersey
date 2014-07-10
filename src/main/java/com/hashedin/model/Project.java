package com.hashedin.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name = "projects")
@NamedQueries({ @NamedQuery(name = "Project.findAll", query = "SELECT p FROM Project p") })
public class Project
{

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

    @ManyToOne
    private User owner;

    @ElementCollection
    @OneToMany(fetch = FetchType.EAGER, mappedBy="project")
    private Set<Task> tasks = new HashSet<>();


    public String getDescription()
    {
        return description;
    }


    public Date getEndDate()
    {
        return endDate;
    }


    public Long getId()
    {
        return id;
    }


    public String getName()
    {
        return name;
    }


    public User getOwner()
    {
        return owner;
    }


    public Date getStartDate()
    {
        return startDate;
    }


    public Set<Task> getTasks()
    {
        return tasks;
    }


    public void setDescription(String description)
    {
        this.description = description;
    }


    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public void setOwner(User owner)
    {
        this.owner = owner;
    }


    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }


    public void setTasks(Set<Task> tasks)
    {
        this.tasks = tasks;
    }

}
