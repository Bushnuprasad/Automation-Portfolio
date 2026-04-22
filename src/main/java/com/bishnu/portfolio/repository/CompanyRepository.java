package com.bishnu.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bishnu.portfolio.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}