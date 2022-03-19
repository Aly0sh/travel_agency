package org.example.controller;

import org.example.dao.daoClasses.countryDaoService;
import org.example.dao.daoClasses.programDaoService;
import org.example.dao.daoClasses.tourDaoService;
import org.example.dao.daoClasses.tourTypeDaoService;
import org.example.models.Country;
import org.example.models.Program;
import org.example.models.Tour_type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
@RequestMapping("/tour")
public class TourController {
    @Autowired
    private tourDaoService tourDaoService;

    @Autowired
    private countryDaoService countryDaoService;

    @Autowired
    private tourTypeDaoService tourTypeDaoService;

    @Autowired
    private programDaoService programDaoService;

    private String name = "Tour";
    private String url = "tour";
    private String fileName = "tour";
    private String redirect = "redirect:/tour/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", tourDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("countries", countryDaoService.getAll());
        model.addAttribute("tour_types", tourTypeDaoService.getAll());
        model.addAttribute("programs", programDaoService.getAll());
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam Integer tour_number,
                         @RequestParam Long tour_type,
                         @RequestParam Long country,
                         @RequestParam Date start_date,
                         @RequestParam Date end_date,
                         @RequestParam Long program_number,
                         @RequestParam String name,
                         @RequestParam String status){
        tourDaoService.create(tour_number, tourTypeDaoService.read(tour_type), countryDaoService.read(country), start_date, end_date, (Program) programDaoService.read(program_number), name, status);
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        tourDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("countries", countryDaoService.getAll());
        model.addAttribute("tour_types", tourTypeDaoService.getAll());
        model.addAttribute("programs", programDaoService.getAll());
        model.addAttribute("obj", tourDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam Integer tour_number,
                           @RequestParam Long tour_type,
                           @RequestParam Long country,
                           @RequestParam Date start_date,
                           @RequestParam Date end_date,
                           @RequestParam Long program_number,
                           @RequestParam String name,
                           @RequestParam String status){
        tourDaoService.update(tour_number, tourTypeDaoService.read(tour_type), countryDaoService.read(country), start_date, end_date, (Program) programDaoService.read(program_number), name, status, id);
        return redirect;
    }
}
