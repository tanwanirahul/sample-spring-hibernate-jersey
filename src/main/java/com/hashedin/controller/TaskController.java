package com.hashedin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hashedin.model.Task;


@Controller
public class TaskController
{

    @RequestMapping(method = RequestMethod.GET, value = "/tasks")
    public ModelAndView getView(@ModelAttribute("tasks") Task task)
    {

        return new ModelAndView("addTask");
    }


    @RequestMapping(method = RequestMethod.POST, value = "/tasks")
    public ModelAndView add(Model model, @ModelAttribute("tasks") Task task)
    {
        return new ModelAndView("taskAdded", "task", task);
    }
}
