package com.jeku.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeku.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
