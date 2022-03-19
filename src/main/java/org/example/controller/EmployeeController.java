package org.example.controller;

import org.example.dao.daoClasses.employeeDaoService;
import org.example.models.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.example.dao.daoClasses.*;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private employeeDaoService employeeDaoService;

    @Autowired
    private positionDaoService positionDaoService;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("list", employeeDaoService.getAll());
        return "employeeList";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("positions", positionDaoService.getAll());
        return "employeeCreate";
    }

    @RequestMapping("/create")
    public String create(@RequestParam("position") Long position_id,
                         @RequestParam("passport_id") Integer passport_id,
                         @RequestParam("name") String name,
                         @RequestParam("address") String address){
        employeeDaoService.create(passport_id, name, address, positionDaoService.read(Long.valueOf(position_id)));
        return "redirect:/employee/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        employeeDaoService.delete(id);
        return "redirect:/employee/list";
    }

    @RequestMapping("/update/{id}")
    public String update(Model model,
                         @PathVariable Long id){
        Employees employees = employeeDaoService.read(id);
        model.addAttribute("emp", employees);
        model.addAttribute("positions", positionDaoService.getAll());
        return "employeeUpdate";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam("position") Long position_id,
                           @RequestParam Integer passport_id,
                           @RequestParam String name,
                           @RequestParam String address){
        employeeDaoService.update(passport_id, name, address, positionDaoService.read(position_id), id);
        return "redirect:/employee/list";
    }
}
