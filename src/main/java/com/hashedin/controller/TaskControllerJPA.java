package com.hashedin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hashedin.model.Task;
import com.hashedin.service.TaskService;

@Controller
public class TaskControllerJPA {

    @Autowired
    TaskService taskService;

    @RequestMapping(method=RequestMethod.GET, value = "/tasks/persistence")
    public String getView(@ModelAttribute("tasks") Task task) {
        return "addTask";
    }
    
    @RequestMapping(method=RequestMethod.POST, value = "/tasks/persistence")
    public String add(Model model, @ModelAttribute("tasks") Task task) {
        task = taskService.save(task);
        model.addAttribute("title", task.getTitle());
        model.addAttribute("id", task.getId());
        return "taskAddedWithId";
    }
}
