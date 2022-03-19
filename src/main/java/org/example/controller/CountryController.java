package org.example.controller;

import org.example.dao.daoClasses.countryDaoService;
import org.example.dao.daoClasses.positionDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private countryDaoService countryDaoService;

    private String redirect = "redirect:/country/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("list", countryDaoService.getAll());
        return "countryList";
    }

    @RequestMapping("/add")
    public String add(){
        return "countryCreate";
    }

    @RequestMapping("/create")
    public String create(@RequestParam("country") String country){
        countryDaoService.create(country);
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        countryDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("obj", countryDaoService.read(id));
        return "countryUpdate";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id, @RequestParam("country") String country){
        countryDaoService.update(country, id);
        return redirect;
    }
}
