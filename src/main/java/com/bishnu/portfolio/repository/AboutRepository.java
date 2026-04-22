package com.bishnu.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bishnu.portfolio.entity.about;

public interface AboutRepository extends JpaRepository<about, Integer> {
}