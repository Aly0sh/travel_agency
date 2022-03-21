package org.example.controller;

import org.example.models.Tour;
import org.hibernate.type.LocalTimeType;
import org.hibernate.type.TimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;

@Controller
@RequestMapping("/event")
public class EventController {
    @Autowired
    private org.example.dao.daoClasses.eventDaoService eventDaoService;

    @Autowired
    private org.example.dao.daoClasses.tourDaoService tourDaoService;

    private String name = "Event";
    private String url = "event";
    private String fileName = "event";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", eventDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("tours", tourDaoService.getAll());
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam String city,
                         @RequestParam String venue,
                         @RequestParam(required = false) String startTime,
                         @RequestParam String name,
                         @RequestParam Long tour){
        eventDaoService.create(city, venue, Time.valueOf(startTime + ":00"), name, (Tour) tourDaoService.read(tour));
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        eventDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("tours", tourDaoService.getAll());
        model.addAttribute("obj", eventDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam String city,
                           @RequestParam String venue,
                           @RequestParam String startTime,
                           @RequestParam String name,
                           @RequestParam Long tour){
        if (startTime.length() == 5){
            startTime += ":00";
        }
        eventDaoService.update(city, venue, Time.valueOf(startTime), name, (Tour) tourDaoService.read(tour), id);
        return redirect;
    }
}
