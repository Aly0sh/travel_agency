package org.example.controller;

import org.example.dao.daoClasses.eventTicketsDaoService;
import org.example.dao.daoClasses.hotelKlassDaoService;
import org.example.dao.daoClasses.tripDaoService;
import org.example.dao.daoClasses.tripTicketsDaoService;
import org.example.models.Event_tickets;
import org.example.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hotel-klass")
public class HotelKlassController {
    @Autowired
    private hotelKlassDaoService hotelKlassDaoService;

    private String name = "Hotel klass";
    private String url = "hotel-klass";
    private String fileName = "hotelKlass";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", hotelKlassDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam String hotel_klass){
        hotelKlassDaoService.create(hotel_klass);
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        hotelKlassDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("obj", hotelKlassDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam String hotel_klass){
        hotelKlassDaoService.update(hotel_klass, id);
        return redirect;
    }
}
