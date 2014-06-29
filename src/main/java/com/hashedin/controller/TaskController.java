package com.hashedin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hashedin.model.Task;

@Controller
public class TaskController {

    @RequestMapping(method=RequestMethod.GET, value = "/tasks")
    public String getView(@ModelAttribute("tasks") Task task) {
        return "addTask";
    }
    
    @RequestMapping(method=RequestMethod.POST, value = "/tasks")
    public String add(Model model, @ModelAttribute("tasks") Task task) {
        model.addAttribute("title", task.getTitle());
        return "taskAdded";
    }
}
