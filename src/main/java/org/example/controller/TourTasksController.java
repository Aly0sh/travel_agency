package org.example.controller;

import org.example.dao.daoClasses.*;
import org.example.models.Program;
import org.example.models.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@RequestMapping("tour-tasks")
public class TourTasksController {
    @Autowired
    private tourTasksDaoService tourTasksDaoService;

    @Autowired
    private employeeDaoService employeeDaoService;

    @Autowired
    private tourDaoService tourDaoService;

    private String name = "Tour tasks";
    private String url = "tour-tasks";
    private String fileName = "tourTasks";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", tourTasksDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("tours", tourDaoService.getAll());
        model.addAttribute("employees", employeeDaoService.getAll());
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam Integer task_number,
                         @RequestParam String description,
                         @RequestParam Date deadline,
                         @RequestParam Long tour,
                         @RequestParam Long employee){
        tourTasksDaoService.create(task_number, description,deadline, (Tour) tourDaoService.read(tour), employeeDaoService.read(employee));
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        tourTasksDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("tours", tourDaoService.getAll());
        model.addAttribute("employees", employeeDaoService.getAll());
        model.addAttribute("obj", tourTasksDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam Integer task_number,
                           @RequestParam String description,
                           @RequestParam Date deadline,
                           @RequestParam Long tour,
                           @RequestParam Long employee){
        tourTasksDaoService.update(task_number, description,deadline, (Tour) tourDaoService.read(tour), employeeDaoService.read(employee), id);
        return redirect;
    }
}
