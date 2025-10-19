package com.bishnu.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AboutMe {
    @Id
    int id;
    String FullName;
    String Tagline;
    String ShortBio;

    public AboutMe(int id, String fullName, String tagline, String shortBio) {
        this.id = id;
        this.FullName = fullName;
        this.Tagline = tagline;
        this.ShortBio = shortBio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        this.FullName = fullName;
    }

    public String getTagline() {
        return Tagline;
    }

    public void setTagline(String tagline) {
        this.Tagline = tagline;
    }

    public String getShortBio() {
        return ShortBio;
    }

    public void setShortBio(String shortBio) {
        this.ShortBio = shortBio;
    }
}
