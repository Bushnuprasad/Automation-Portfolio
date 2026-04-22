package com.bishnu.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bishnu.portfolio.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}