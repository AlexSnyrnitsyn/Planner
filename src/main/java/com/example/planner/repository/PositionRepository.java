package com.example.planner.repository;

import com.example.planner.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PositionRepository extends JpaRepository<Position, Long> {
}
