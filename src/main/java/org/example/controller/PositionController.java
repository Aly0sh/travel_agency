package org.example.controller;

import org.example.dao.daoClasses.positionDaoService;
import org.example.models.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private positionDaoService positionDaoService;

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("positions", positionDaoService.getAll());
        return "positionList";
    }

    @RequestMapping("/add")
    public String add(){
        return "positionCreate";
    }

    @RequestMapping("/create")
    public String create(@RequestParam("position") String position){
        positionDaoService.create(position);
        return "redirect:/position/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        positionDaoService.delete(id);
        return "redirect:/position/list";
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("pos", positionDaoService.read(id));
        return "positionUpdate";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id, @RequestParam("position") String position){
        positionDaoService.update(position, id);
        return "redirect:/position/list";
    }
}
