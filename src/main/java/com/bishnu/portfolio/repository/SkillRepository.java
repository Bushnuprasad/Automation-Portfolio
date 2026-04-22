package com.bishnu.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bishnu.portfolio.entity.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {
}