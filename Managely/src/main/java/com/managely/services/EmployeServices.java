package com.managely.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.managely.models.Employee;
import com.managely.repository.EmployeeRepository;

@Service
public class EmployeServices {
	@Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    public Object createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Object updateEmployee(int id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(employee -> {
            ((Employee) employee).setName(updatedEmployee.getName());
            ((Employee) employee).setSalary(updatedEmployee.getSalary());
            ((Employee) employee).setAge(updatedEmployee.getAge());
            return employeeRepository.save(employee);
        }).orElseGet(() -> {
            updatedEmployee.setId(id);
            return employeeRepository.save(updatedEmployee);
        });
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
