package com.jeku.service;
import java.util.List;
import java.util.Map;
import com.jeku.entity.*;
public interface PlanService {
		
	//get plan categories
	public Map<Integer,String> getPlanCategories();
	
	//create plan
	public boolean savePlan(Plan plan);
	
	//view all plan
	
	public List<Plan> getallPlans();
	
	//get single plan 
	public Plan getPlanbyID(Integer planId);
	
	//update plan
	public boolean updatePlan(Plan plan);
	
	//delete plan hard delete
	public Boolean deletePlanbyID(Integer planId);
	
	//activate /deactivate
	public boolean planStatusChange(Integer id,String activeSw);
}