package com.bishnu.portfolio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Skill {
    @Id
    int id;
    String SkillName;
    int ProficiencyLevel;
    String IconPath;

    public Skill(int id, String skillName, int proficiencyLevel, String iconPath) {
        this.id = id;
        this.SkillName = skillName;
        this.ProficiencyLevel = proficiencyLevel;
        this.IconPath = iconPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkillName() {
        return SkillName;
    }

    public void setSkillName(String skillName) {
        this.SkillName = skillName;
    }

    public int getProficiencyLevel() {
        return ProficiencyLevel;
    }

    public void setProficiencyLevel(int proficiencyLevel) {
        this.ProficiencyLevel = proficiencyLevel;
    }

    public String getIconPath() {
        return IconPath;
    }

    public void setIconPath(String iconPath) {
        this.IconPath = iconPath;
    }
}