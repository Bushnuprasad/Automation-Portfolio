package com.bishnu.portfolio.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bishnu.portfolio.entity.Home;
import com.bishnu.portfolio.repository.homeRpository;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private homeRpository homeRepo;
    String uploadDir = System.getProperty("user.dir") + "/uploads/";

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
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String fileName = System.currentTimeMillis() + "_" +
                file.getOriginalFilename().replaceAll(" ", "_");
        String filePath = uploadDir + fileName;
        Home home = homeRepo.findAll().stream().findFirst().orElse(new Home());
        if (home.getImagePath() != null) {
            File oldFile = new File(System.getProperty("user.dir") + "/" + home.getImagePath());
            if (oldFile.exists()) {
                oldFile.delete();
            }
        }
        file.transferTo(new File(filePath));
        home.setName(name);
        home.setTagline(tagline);
        home.setShortBio(shortBio);
        home.setImagePath("uploads/" + fileName);
        homeRepo.save(home);
        return "redirect:/admin/dashboard";
    }
}
