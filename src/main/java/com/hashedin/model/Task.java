package com.hashedin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
@Table(name = "tasks")
@NamedQueries({ @NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t") })
public class Task
{

    @Id
    @GeneratedValue
    private Long id;
    
    private String title;
    
    private Date creationDate;

    private Date expectedEndDate;
    
    @ManyToOne
    private User assignee;

    @ManyToOne
    private Project project;

    public User getAssignee()
    {
        return assignee;
    }


    public Date getCreationDate()
    {
        return creationDate;
    }


    public Date getExpectedEndDate()
    {
        return expectedEndDate;
    }


    public Long getId()
    {
        return id;
    }


    public String getTitle()
    {
        return title;
    }


    public void setAssignee(User assignee)
    {
        this.assignee = assignee;
    }


    public void setCreationDate(Date creationDate)
    {
        this.creationDate = creationDate;
    }


    public void setExpectedEndDate(Date expectedEndDate)
    {
        this.expectedEndDate = expectedEndDate;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public void setTitle(String title)
    {
        this.title = title;
    }

}
