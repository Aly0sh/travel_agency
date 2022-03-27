package org.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String homePage(Model model){
        return "home";
    }

    @RequestMapping("/login")
    public String auth(Model model){
        return "login";
    }

    @RequestMapping("/sign-up")
    public String reg(Model model){
        return "sign_up";
    }


}
