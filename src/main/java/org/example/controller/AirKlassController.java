package org.example.controller;

import org.example.dao.daoClasses.airKlassDaoService;
import org.example.dao.daoClasses.hotelKlassDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/air-klass")
public class AirKlassController {
    @Autowired
    private org.example.dao.daoClasses.airKlassDaoService airKlassDaoService;

    private String name = "Air klass";
    private String url = "air-klass";
    private String fileName = "airKlass";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", airKlassDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam String klass){
        airKlassDaoService.create(klass);
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        airKlassDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("obj", airKlassDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam String klass){
        airKlassDaoService.update(klass, id);
        return redirect;
    }
}
