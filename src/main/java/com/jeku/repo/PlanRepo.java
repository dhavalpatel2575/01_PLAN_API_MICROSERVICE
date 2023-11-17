package com.jeku.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeku.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
