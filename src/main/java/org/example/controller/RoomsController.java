package org.example.controller;

import org.example.dao.daoClasses.*;
import org.example.models.Category;
import org.example.models.Hotel;
import org.example.models.Hotel_klass;
import org.example.models.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@RequestMapping("/rooms")
public class RoomsController {
    @Autowired
    private roomsDaoService roomsDaoService;

    @Autowired
    private categoryDaoService categoryDaoService;

    @Autowired
    private hotelDaoService hotelDaoService;

    private String name = "Room";
    private String url = "rooms";
    private String fileName = "rooms";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", roomsDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("hotels", hotelDaoService.getAll());
        model.addAttribute("categories", categoryDaoService.getAll());
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam Date arrival_date,
                         @RequestParam Date departure_date,
                         @RequestParam Integer place,
                         @RequestParam Long hotel,
                         @RequestParam Long category){
        roomsDaoService.create(arrival_date, departure_date, place, (Hotel) hotelDaoService.read(hotel), (Category) categoryDaoService.read(category));
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        roomsDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("categories", categoryDaoService.getAll());
        model.addAttribute("hotels", hotelDaoService.getAll());
        model.addAttribute("obj", roomsDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam Date arrival_date,
                           @RequestParam Date departure_date,
                           @RequestParam Integer place,
                           @RequestParam Long hotel,
                           @RequestParam Long category){
        roomsDaoService.update(arrival_date, departure_date, place, (Hotel) hotelDaoService.read(hotel), (Category) categoryDaoService.read(category), id);
        return redirect;
    }
}
