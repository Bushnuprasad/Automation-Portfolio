package com.bishnu.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Home {
    @Id
    int id;
    String Name;
    String Tagline;
    String ShortBio;
    String Imagepath;

    public Home(int id, String name, String tagline, String shortBio, String imagepath) {
        this.id = id;
        this.Name = name;
        this.Tagline = tagline;
        this.ShortBio = shortBio;
        this.Imagepath = imagepath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTagline() {
        return Tagline;
    }

    public void setTagline(String tagline) {
        Tagline = tagline;
    }

    public String getShortBio() {
        return ShortBio;
    }

    public void setShortBio(String shortBio) {
        ShortBio = shortBio;
    }

    public String getImagepath() {
        return Imagepath;
    }

    public void setImagepath(String imagepath) {
        Imagepath = imagepath;
    }
}
