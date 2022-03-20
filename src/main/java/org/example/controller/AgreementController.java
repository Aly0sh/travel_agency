package org.example.controller;

import org.example.dao.daoClasses.agreementDaoService;
import org.example.dao.daoClasses.clientDaoService;
import org.example.dao.daoClasses.orderDaoService;
import org.example.dao.daoClasses.tourDaoService;
import org.example.models.Client;
import org.example.models.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@RequestMapping("/agreement")
public class AgreementController {
    @Autowired
    private agreementDaoService agreementDaoService;

    @Autowired
    private clientDaoService clientDaoService;

    @Autowired
    private org.example.dao.daoClasses.tourDaoService tourDaoService;

    private String name = "Agreement";
    private String url = "agreement";
    private String fileName = "agreement";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", agreementDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("tours", tourDaoService.getAll());
        model.addAttribute("clients", clientDaoService.getAll());
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam Integer agreement_number,
                         @RequestParam Date registration_date,
                         @RequestParam Long tour,
                         @RequestParam Long client){
        agreementDaoService.create(agreement_number, registration_date, (Tour) tourDaoService.read(tour), (Client) clientDaoService.read(client));
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        agreementDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("tours", tourDaoService.getAll());
        model.addAttribute("clients", clientDaoService.getAll());
        model.addAttribute("obj", agreementDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam Integer agreement_number,
                           @RequestParam Date registration_date,
                           @RequestParam Long tour,
                           @RequestParam Long client){
        agreementDaoService.update(agreement_number, registration_date, (Tour) tourDaoService.read(tour), (Client) clientDaoService.read(client), id);
        return redirect;
    }
}
