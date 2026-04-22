package com.bishnu.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bishnu.portfolio.entity.Experience;

public interface ExperienceRepository extends JpaRepository<Experience, Integer> {
}