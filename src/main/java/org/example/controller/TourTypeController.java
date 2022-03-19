package org.example.controller;

import org.example.dao.daoClasses.tourTypeDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/tour-type")
public class TourTypeController{
    @Autowired
    private tourTypeDaoService tourTypeDaoService;

    private String fileName = "tourType";
    private String redirect = "redirect:/tour-type/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("list", tourTypeDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(){
        return fileName + "Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam("tourType") String tourType){
        tourTypeDaoService.create(tourType);
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        tourTypeDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("obj", tourTypeDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id, @RequestParam("tourType") String tourType){
        tourTypeDaoService.update(tourType, id);
        return redirect;
    }
}
