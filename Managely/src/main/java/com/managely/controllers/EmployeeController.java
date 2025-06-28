	package com.managely.controllers;
	
	import java.util.List;
	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;
	
	import com.managely.models.Employee;
	import com.managely.services.EmployeServices;
	
	@RestController
	@RequestMapping("/api/employees") // Base URL for all endpoints
	@CrossOrigin(origins = "http://localhost:3000")
	public class EmployeeController {
	
	    @Autowired 
	    private EmployeServices employeeService;
	
	    // GET: All Employees
	    @GetMapping
	    public List<Employee> getAllEmployees() {
	        return employeeService.getAllEmployees();
	    }
	
	    // GET: Single Employee by ID
	    @GetMapping("/{id}")
	    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
	        return employeeService.getEmployeeById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }
	
	    // POST: Create Employee
	    @PostMapping
	    public Employee createEmployee(@RequestBody Employee employee) {
	        return (Employee) employeeService.createEmployee(employee);
	    }
	
	    // PUT: Update Employee
	    @PutMapping("/{id}")
	    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
	        return (Employee) employeeService.updateEmployee(id, employee);
	    }
	
	    // DELETE: Remove Employee
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
	        employeeService.deleteEmployee(id);
	        return ResponseEntity.noContent().build();
	    }
	}
