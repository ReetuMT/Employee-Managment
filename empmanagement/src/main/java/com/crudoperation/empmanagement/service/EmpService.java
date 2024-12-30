package com.crudoperation.empmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudoperation.empmanagement.enitity.Employee;
import com.crudoperation.empmanagement.repository.EmpRepo;

import jakarta.transaction.Transactional;

@Service
public class EmpService {

	@Autowired
	private EmpRepo empRepo;
	public Employee addemployee(Employee emp) {
        System.out.println("Saving employee: " + emp);
        return empRepo.save(emp);
    }
	
	public List<Employee> getAllEmployee(){
		return empRepo.findAll();
	}
	public Employee updateEmploye(Employee updateemp) {
	    // Fetch the existing employee by ID
	    Optional<Employee> optionalEmp = empRepo.findById(updateemp.getId());
	    
	    if (optionalEmp.isPresent()) {
	        // Update only the modifiable fields
	        Employee existingEmp = optionalEmp.get();
	        existingEmp.setName(updateemp.getName());
	        existingEmp.setDept(updateemp.getDept());
	        existingEmp.setAge(updateemp.getAge());
	        return empRepo.save(existingEmp);
	    } else {
	     
	        throw new RuntimeException("Employee with ID " + updateemp.getId() + " not found");
	    }
	}
	public Boolean deleteEmpl(int id) {
		empRepo.deleteById(id);
		return true;
	}
	
}
