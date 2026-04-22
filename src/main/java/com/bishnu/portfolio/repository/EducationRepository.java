package com.bishnu.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bishnu.portfolio.entity.Education;

public interface EducationRepository extends JpaRepository<Education, Integer> {
}