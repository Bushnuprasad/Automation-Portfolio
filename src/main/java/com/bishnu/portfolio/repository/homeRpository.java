package com.bishnu.portfolio.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bishnu.portfolio.entity.Home;

public interface homeRpository extends JpaRepository<Home, Integer> {
}