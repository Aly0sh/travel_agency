package org.example.controller;

import org.example.dao.daoClasses.eventTicketsDaoService;
import org.example.models.Events;
import org.example.models.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Time;

@Controller
@RequestMapping("/event-ticket")
public class EventTicketController {
    @Autowired
    private org.example.dao.daoClasses.eventDaoService eventDaoService;

    @Autowired
    private eventTicketsDaoService eventTicketsDaoService;

    private String name = "Event tickets";
    private String url = "event-ticket";
    private String fileName = "eventTicket";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", eventTicketsDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("events", eventDaoService.getAll());
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam Integer place,
                         @RequestParam Long events){
        eventTicketsDaoService.create(place, (Events) eventDaoService.read(events));
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        eventTicketsDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("events", eventDaoService.getAll());
        model.addAttribute("obj", eventTicketsDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam Integer place,
                           @RequestParam Long events){
        eventTicketsDaoService.update(place, (Events) eventDaoService.read(events), id);
        return redirect;
    }
}
