package com.crudoperation.empmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crudoperation.empmanagement.enitity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee,Integer>{
	

}
