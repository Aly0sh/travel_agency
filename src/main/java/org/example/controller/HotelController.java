package org.example.controller;

import org.example.dao.daoClasses.*;
import org.example.models.Event_tickets;
import org.example.models.Hotel_klass;
import org.example.models.Tour;
import org.example.models.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private hotelDaoService hotelDaoService;

    @Autowired
    private tourDaoService tourDaoService;

    @Autowired
    private hotelKlassDaoService hotelKlassDaoService;

    private String name = "Hotel";
    private String url = "hotel";
    private String fileName = "hotel";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", hotelDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("tours", tourDaoService.getAll());
        model.addAttribute("hotelKlasses", hotelKlassDaoService.getAll());
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam String city,
                         @RequestParam String name,
                         @RequestParam Long tour,
                         @RequestParam Long hotel_klass){
        hotelDaoService.create(city, name, (Tour) tourDaoService.read(tour), (Hotel_klass) hotelKlassDaoService.read(hotel_klass));
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        hotelDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("tours", tourDaoService.getAll());
        model.addAttribute("hotelKlasses", hotelKlassDaoService.getAll());
        model.addAttribute("obj", hotelDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam String city,
                           @RequestParam String name,
                           @RequestParam Long tour,
                           @RequestParam Long hotel_klass){
        hotelDaoService.update(city, name, (Tour) tourDaoService.read(tour), (Hotel_klass) hotelKlassDaoService.read(hotel_klass), id);
        return redirect;
    }
}
