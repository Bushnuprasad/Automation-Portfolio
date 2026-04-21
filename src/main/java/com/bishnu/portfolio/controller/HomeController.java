package com.bishnu.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bishnu.portfolio.entity.Home;
import com.bishnu.portfolio.repository.homeRpository;

@Controller
@RequestMapping("/Bishnuprasad")
public class HomeController {

    @Autowired
    private homeRpository homeRepo;

    @GetMapping("/dashboard")
    public String showUserDashboard(Model model) {
        Home home = homeRepo.findAll().stream().findFirst().orElse(null);
        model.addAttribute("home", home);
        return "index";
    }
}