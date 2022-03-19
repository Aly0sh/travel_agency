package org.example.controller;


import org.example.dao.daoClasses.orderDaoService;
import org.example.models.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private orderDaoService orderDaoService;

    @Autowired
    private org.example.dao.daoClasses.employeeDaoService employeeDaoService;

    @Autowired
    private org.example.dao.daoClasses.tourDaoService tourDaoService;

    private String name = "Order";
    private String url = "order";
    private String fileName = "order";
    private String redirect = "redirect:/" + url + "/list";

    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("list", orderDaoService.getAll());
        return fileName + "List";
    }

    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("tours", tourDaoService.getAll());
        model.addAttribute("employees", employeeDaoService.getAll());
        return fileName+"Create";
    }

    @RequestMapping("/create")
    public String create(@RequestParam Integer order_number,
                         @RequestParam Long tour,
                         @RequestParam Long employee){
        orderDaoService.create(order_number, (Tour) tourDaoService.read(tour), employeeDaoService.read(employee));
        return redirect;
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        orderDaoService.delete(id);
        return redirect;
    }

    @RequestMapping("/update/{id}")
    public String update(Model model, @PathVariable Long id){
        model.addAttribute("name", name);
        model.addAttribute("url", url);
        model.addAttribute("tours", tourDaoService.getAll());
        model.addAttribute("employees", employeeDaoService.getAll());
        model.addAttribute("obj", orderDaoService.read(id));
        return fileName + "Update";
    }

    @RequestMapping("do-update/{id}")
    public String doUpdate(@PathVariable Long id,
                           @RequestParam Integer order_number,
                           @RequestParam Long tour,
                           @RequestParam Long employee){
        orderDaoService.update(order_number, (Tour) tourDaoService.read(tour), employeeDaoService.read(employee), id);
        return redirect;
    }
}
