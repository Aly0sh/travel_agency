package org.example.controller;

import org.example.dao.daoClasses.clientDaoService;
import org.example.dao.daoClasses.employeeDaoService;
import org.example.dao.daoClasses.tourDaoService;
import org.example.dao.daoClasses.tourTasksDaoService;
import org.example.models.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private clientDaoService clientDaoService;

    private String name = "Client";
    private String url = "client";
    private String fileName = "client";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", clientDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam  String name,
                         @RequestParam  String address,
                         @RequestParam  Integer client_number,
                         @RequestParam  Integer phone){
        clientDaoService.create(name, address, client_number, phone);
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        clientDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("obj", clientDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam  String name,
                           @RequestParam  String address,
                           @RequestParam  Integer client_number,
                           @RequestParam  Integer phone){
        clientDaoService.update(name, address, client_number, phone, id);
        return redirect;
    }
}
