package com.hashedin.model;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlInverseReference;


@XmlRootElement
@Entity
@Table(name = "users")
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u") })
public class User
{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String emailId;

    @XmlInverseReference(mappedBy="assignee")
    @ElementCollection
    @OneToMany(fetch = FetchType.EAGER, mappedBy="assignee")
    private Set<Task> tasks;

    @XmlInverseReference(mappedBy="owner")
    @ElementCollection
    @OneToMany(fetch = FetchType.EAGER, mappedBy="owner")
    private Set<Project> owningProject;

    public String getEmailId()
    {
        return emailId;
    }


    public Long getId()
    {
        return id;
    }


    public String getName()
    {
        return name;
    }


    public Set<Task> getTasks()
    {
        return tasks;
    }


    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public void setName(String name)
    {
        this.name = name;
    }


    public void setTasks(Set<Task> tasks)
    {
        this.tasks = tasks;
    }
}
