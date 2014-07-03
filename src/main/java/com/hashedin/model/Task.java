package com.hashedin.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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


    public Long getId()
    {
        return id;
    }


    public String getTitle()
    {
        return title;
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
