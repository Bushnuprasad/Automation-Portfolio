package com.bishnu.portfolio.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bishnu.portfolio.entity.Company;
import com.bishnu.portfolio.entity.Education;
import com.bishnu.portfolio.entity.Experience;
import com.bishnu.portfolio.entity.Home;
import com.bishnu.portfolio.entity.Project;
import com.bishnu.portfolio.entity.Skill;
import com.bishnu.portfolio.entity.about;
import com.bishnu.portfolio.repository.AboutRepository;
import com.bishnu.portfolio.repository.CompanyRepository;
import com.bishnu.portfolio.repository.EducationRepository;
import com.bishnu.portfolio.repository.ExperienceRepository;
import com.bishnu.portfolio.repository.ProjectRepository;
import com.bishnu.portfolio.repository.SkillRepository;
import com.bishnu.portfolio.repository.homeRpository;
import com.cloudinary.Cloudinary;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private homeRpository homeRepo;
    String uploadDir = System.getProperty("user.dir") + "/uploads/";
    @Autowired
    private Cloudinary cloudinary;
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
    public String showAdminDashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/userdashboard")
    public String showUserDashboard() {
        return "index";
    }

    @PostMapping("/saveHome")
    public String saveHome(
            @RequestParam("name") String name,
            @RequestParam("tagline") String tagline,
            @RequestParam("shortBio") String shortBio,
            @RequestParam("imageFile") MultipartFile file) throws IOException {
        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), Map.of());
        String imageUrl = uploadResult.get("url").toString();
        Home home = homeRepo.findAll().stream().findFirst().orElse(new Home());
        home.setName(name);
        home.setTagline(tagline);
        home.setShortBio(shortBio);
        home.setImagePath(imageUrl);
        homeRepo.save(home);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(
            @RequestParam("companyName") String companyName,
            @RequestParam("shortBio") String shortBio,
            @RequestParam("imageFile") MultipartFile file) throws IOException {
        String imageUrl = null;
        if (!file.isEmpty()) {
            Map uploadResult = cloudinary.uploader().upload(file.getBytes(), Map.of());
            imageUrl = uploadResult.get("url").toString();
        }
        Company company = companyRepo.findAll().stream().findFirst().orElse(new Company());
        company.setCompanyName(companyName);
        company.setShortBio(shortBio);
        if (imageUrl != null) {
            company.setImagePath(imageUrl);
        }
        companyRepo.save(company);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/saveAbout")
    public String saveAbout(
            @RequestParam String name,
            @RequestParam String tagline,
            @RequestParam String shortBio) {
        about about = aboutRepo.findAll().stream().findFirst().orElse(new about());
        about.setName(name);
        about.setTagline(tagline);
        about.setShortBio(shortBio);
        aboutRepo.save(about);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/saveSkill")
    public String saveSkill(
            @RequestParam String name,
            @RequestParam int level) {
        Skill skill = new Skill();
        skill.setName(name);
        skill.setLevel(level);
        skillRepo.save(skill);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/saveProject")
    public String saveProject(
            @RequestParam String companyName,
            @RequestParam String title,
            @RequestParam String role,
            @RequestParam String description,
            @RequestParam String technology,
            @RequestParam String startDate,
            @RequestParam String endDate,
            @RequestParam("image") MultipartFile image) throws Exception {
        Project p = new Project();
        p.setCompanyName(companyName);
        p.setTitle(title);
        p.setRole(role);
        p.setDescription(description);
        p.setTechnology(technology);
        p.setStartDate(LocalDate.parse(startDate));
        p.setEndDate(LocalDate.parse(endDate));
        if (!image.isEmpty()) {
            Map uploadResult = cloudinary.uploader().upload(
                    image.getBytes(),
                    Map.of("folder", "portfolio_projects"));
            String imageUrl = uploadResult.get("secure_url").toString();
            p.setImagePath(imageUrl);
        }
        projectRepo.save(p);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/saveExperience")
    public String saveExperience(
            @RequestParam String companyName,
            @RequestParam String jobTitle,
            @RequestParam String shortBio,
            @RequestParam("imageFile") MultipartFile image) throws Exception {
        Experience exp = new Experience();
        exp.setCompanyName(companyName);
        exp.setJobTitle(jobTitle);
        exp.setShortBio(shortBio);
        if (!image.isEmpty()) {
            Map uploadResult = cloudinary.uploader().upload(
                    image.getBytes(),
                    Map.of("folder", "portfolio_experience"));

            String imageUrl = uploadResult.get("secure_url").toString();
            exp.setImagePath(imageUrl);
        }
        experienceRepo.save(exp);
        return "redirect:/admin/dashboard";
    }

    @PostMapping("/saveEducation")
    public String saveEducation(
            @RequestParam String name,
            @RequestParam String tagline,
            @RequestParam String shortBio) throws Exception {
        Education edu = new Education();
        edu.setName(name);
        edu.setTagline(tagline);
        edu.setShortBio(shortBio);
        educationRepo.save(edu);
        return "redirect:/admin/dashboard";
    }
}
