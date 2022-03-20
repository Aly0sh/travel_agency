package org.example.controller;

import org.example.dao.daoClasses.agreementDaoService;
import org.example.dao.daoClasses.clientDaoService;
import org.example.dao.daoClasses.tripDaoService;
import org.example.models.Agreement;
import org.example.models.Client;
import org.example.models.Tour;
import org.example.models.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@RequestMapping("/trip")
public class TripController {
    @Autowired
    private agreementDaoService agreementDaoService;

    @Autowired
    private tripDaoService tripDaoService;

    @Autowired
    private org.example.dao.daoClasses.touristDaoService touristDaoService;

    private String name = "Trip";
    private String url = "trip";
    private String fileName = "trip";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", tripDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("agreements", agreementDaoService.getAll());
        model.addAttribute("tourists", touristDaoService.getAll());
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam Integer tripNumber,
                         @RequestParam Long agreement,
                         @RequestParam Long tourist){
        tripDaoService.create(tripNumber, (Agreement) agreementDaoService.read(agreement), (Tourist) touristDaoService.read(tourist));
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        tripDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("agreements", agreementDaoService.getAll());
        model.addAttribute("tourists", touristDaoService.getAll());
        model.addAttribute("obj", tripDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam Integer tripNumber,
                           @RequestParam Long agreement,
                           @RequestParam Long tourist){
        tripDaoService.update(tripNumber, (Agreement) agreementDaoService.read(agreement), (Tourist) touristDaoService.read(tourist), id);
        return redirect;
    }
}
