package com.bishnu.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bishnu.portfolio.entity.Company;
import com.bishnu.portfolio.entity.Home;
import com.bishnu.portfolio.entity.about;
import com.bishnu.portfolio.repository.AboutRepository;
import com.bishnu.portfolio.repository.CompanyRepository;
import com.bishnu.portfolio.repository.EducationRepository;
import com.bishnu.portfolio.repository.ExperienceRepository;
import com.bishnu.portfolio.repository.ProjectRepository;
import com.bishnu.portfolio.repository.SkillRepository;
import com.bishnu.portfolio.repository.homeRpository;

@Controller
@RequestMapping("/Bishnuprasad")
public class HomeController {

    @Autowired
    private homeRpository homeRepo;
    @Autowired
    private CompanyRepository companyRepo;
    @Autowired
    private AboutRepository aboutRepo;
    @Autowired
    private SkillRepository skillRepo;
    @Autowired
    private ProjectRepository projectRepo;
    @Autowired
    private ExperienceRepository experienceRepo;
    @Autowired
    private EducationRepository educationRepo;

    @GetMapping("/dashboard")
    public String showUserDashboard(Model model) {
        Home home = homeRepo.findAll().stream().findFirst().orElse(null);
        model.addAttribute("home", home);
        Company company = companyRepo.findAll().stream().findFirst().orElse(null);
        model.addAttribute("company", company);
        about about = aboutRepo.findAll().stream().findFirst().orElse(new about());
        model.addAttribute("about", about);
        model.addAttribute("skills", skillRepo.findAll());
        model.addAttribute("projects", projectRepo.findAll());
        model.addAttribute("experiences", experienceRepo.findAll());
        model.addAttribute("educations", educationRepo.findAll());
        return "index";
    }
}