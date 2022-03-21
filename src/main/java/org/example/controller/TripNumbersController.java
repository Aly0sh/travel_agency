package org.example.controller;

import org.example.dao.daoClasses.*;
import org.example.models.Event_tickets;
import org.example.models.Rooms;
import org.example.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/trip-numbers")
public class TripNumbersController {
    @Autowired
    private tripDaoService tripDaoService;

    @Autowired
    private roomsDaoService roomsDaoService;

    @Autowired
    private tripNumbersDaoService tripNumbersDaoService;

    private String name = "Trip numbers";
    private String url = "trip-numbers";
    private String fileName = "tripNumbers";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", tripNumbersDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("rooms", roomsDaoService.getAll());
        model.addAttribute("trips", tripDaoService.getAll());
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam Long room,
                         @RequestParam Long trip){
        tripNumbersDaoService.create((Rooms) roomsDaoService.read(room), (Trip) tripDaoService.read(trip));
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        tripNumbersDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("rooms", roomsDaoService.getAll());
        model.addAttribute("trips", tripDaoService.getAll());
        model.addAttribute("obj", tripNumbersDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam Long room,
                           @RequestParam Long trip){
        tripNumbersDaoService.update((Rooms) roomsDaoService.read(room), (Trip) tripDaoService.read(trip), id);
        return redirect;
    }
}
