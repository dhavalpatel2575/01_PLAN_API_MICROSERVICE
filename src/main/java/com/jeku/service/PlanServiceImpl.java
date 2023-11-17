package com.jeku.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jeku.entity.Plan;
import com.jeku.entity.PlanCategory;
import com.jeku.repo.PlanCategoryRepo;
import com.jeku.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService{

	
	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private PlanCategoryRepo planCategoryRepo;
	
	
	@Override
	public Map<Integer, String> getPlanCategories() {
		
		List<PlanCategory> categories=planCategoryRepo.findAll();
		Map<Integer,String> categorymap=new HashMap<>();
		categories.forEach(Category->{
			categorymap.put(Category.getCategoryId(),Category.getCategoryName());
		});
		return categorymap;
	}

	@Override
	public boolean savePlan(Plan plan) {
		Plan saved=planRepo.save(plan);
		//return saved.getPlanId()!=null?true:false;
		return saved.getPlanId()!=null;
	}

	@Override
	public List<Plan> getallPlans() {
	//	List<Plan> plans=planRepo.findAll();
		//return plans;
		
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanbyID(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent()) {
			return findById.get();
		} 
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		planRepo.save(plan);
		return plan.getPlanId()!=null;
	}

	@Override
	public Boolean deletePlanbyID(Integer planId) {
		boolean status=false;
		try {
			planRepo.deleteById(planId);
			status=true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		planRepo.deleteById(planId);
		return status;
	}
	@Override
	public boolean planStatusChange(Integer planId, String status) {
		Optional<Plan> findById = planRepo.findById(planId);
		// if record is present then 
		if(findById.isPresent()) {
			Plan plan=findById.get(); 
			plan.setPlanId(planId);
			plan.setActiveSw(status);
			planRepo.save(plan);
			return true;	
		}
		return false;
	}
}