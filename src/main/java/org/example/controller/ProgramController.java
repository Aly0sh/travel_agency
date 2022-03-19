package org.example.controller;

import org.example.dao.daoClasses.programDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/program")
public class ProgramController {
    @Autowired
    private programDaoService programDaoService;

    private String fileName = "program";
    private String redirect = "redirect:/program/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("list", programDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(){
        return fileName + "Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam("program_number") Integer program_number,
                         @RequestParam("description") String description){
        programDaoService.create(program_number, description);
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        programDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("obj", programDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam("program_number") Integer program_number,
                           @RequestParam("description") String description){
        programDaoService.update(program_number, description, id);
        return redirect;
    }
}
