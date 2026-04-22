package com.bishnu.portfolio.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bishnu.portfolio.entity.Company;
import com.bishnu.portfolio.entity.Home;
import com.bishnu.portfolio.repository.CompanyRepository;
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
}
