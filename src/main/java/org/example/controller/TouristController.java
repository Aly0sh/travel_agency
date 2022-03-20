package org.example.controller;

import org.example.dao.daoClasses.clientDaoService;
import org.example.dao.daoClasses.touristDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tourist")
public class TouristController {
    @Autowired
    private touristDaoService touristDaoService;

    private String name = "Tourist";
    private String url = "tourist";
    private String fileName = "tourist";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", touristDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam Integer passport_id,
                         @RequestParam String name,
                         @RequestParam String address,
                         @RequestParam Integer age){
        touristDaoService.create(passport_id, name, address, age);
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        touristDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("obj", touristDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam Integer passport_id,
                           @RequestParam String name,
                           @RequestParam String address,
                           @RequestParam Integer age){
        touristDaoService.update(passport_id, name, address, age, id);
        return redirect;
    }
}
