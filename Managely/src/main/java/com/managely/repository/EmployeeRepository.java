package com.managely.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.managely.models.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,Integer >{
	
	
	

}
