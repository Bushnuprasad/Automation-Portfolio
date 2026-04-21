package com.bishnu.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String tagline;
    private String shortBio;
    private String imagePath;

    // 🔹 Default Constructor (JPA ke liye mandatory)
    public Home() {
    }

    // 🔹 Parameterized Constructor
    public Home(int id, String name, String tagline, String shortBio, String imagePath) {
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.shortBio = shortBio;
        this.imagePath = imagePath;
    }

    // 🔹 Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}