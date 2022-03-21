package org.example.controller;

import org.example.dao.daoClasses.tourFlightsDaoService;
import org.example.models.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.sql.Time;

@Controller
@RequestMapping("/tour-flights")
public class TourFlightsController {
    @Autowired
    private tourFlightsDaoService tourFlightsDaoService;

    @Autowired
    private org.example.dao.daoClasses.tourDaoService tourDaoService;

    private String name = "Tour flights";
    private String url = "tour-flights";
    private String fileName = "tourFlights";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", tourFlightsDaoService.getAll());
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
    public String create(@RequestParam Integer flight_code,
                         @RequestParam String air_company,
                         @RequestParam Date departure_date,
                         @RequestParam String departure_time,
                         @RequestParam String arrival_city,
                         @RequestParam String departure_city,
                         @RequestParam String directions,
                         @RequestParam Long tour){
        tourFlightsDaoService.create(flight_code, air_company, departure_date, Time.valueOf(departure_time + ":00"), arrival_city, departure_city, directions, (Tour) tourDaoService.read(tour));
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        tourFlightsDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("tours", tourDaoService.getAll());
        model.addAttribute("obj", tourFlightsDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam Integer flight_code,
                           @RequestParam String air_company,
                           @RequestParam Date departure_date,
                           @RequestParam String departure_time,
                           @RequestParam String arrival_city,
                           @RequestParam String departure_city,
                           @RequestParam String directions,
                           @RequestParam Long tour){
        if (departure_time.length() == 5){
            departure_time += ":00";
        }
        tourFlightsDaoService.update(flight_code, air_company, departure_date, Time.valueOf(departure_time), arrival_city, departure_city, directions, (Tour) tourDaoService.read(tour), id);
        return redirect;
    }
}
