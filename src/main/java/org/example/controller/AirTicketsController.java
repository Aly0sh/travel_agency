package org.example.controller;

import org.example.dao.daoClasses.*;
import org.example.models.Air_klass;
import org.example.models.Hotel_klass;
import org.example.models.Tour;
import org.example.models.Tour_flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/air-tickets")
public class AirTicketsController {
    @Autowired
    private airTicketsDaoService airTicketsDaoService;

    @Autowired
    private tourFlightsDaoService tourFlightsDaoService;

    @Autowired
    private airKlassDaoService airKlassDaoService;

    private String name = "Air tickets";
    private String url = "air-tickets";
    private String fileName = "airTickets";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", airTicketsDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("airKlasses", airKlassDaoService.getAll());
        model.addAttribute("tourFlights", tourFlightsDaoService.getAll());
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam Integer place,
                         @RequestParam Long tour_flights,
                         @RequestParam Long air_klass){
        airTicketsDaoService.create(place, (Tour_flights) tourFlightsDaoService.read(tour_flights), (Air_klass) airKlassDaoService.read(air_klass));
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        airTicketsDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("airKlasses", airKlassDaoService.getAll());
        model.addAttribute("tourFlights", tourFlightsDaoService.getAll());
        model.addAttribute("obj", airTicketsDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam Integer place,
                           @RequestParam Long tour_flights,
                           @RequestParam Long air_klass){
        airTicketsDaoService.update(place, (Tour_flights) tourFlightsDaoService.read(tour_flights), (Air_klass) airKlassDaoService.read(air_klass), id);
        return redirect;
    }
}
