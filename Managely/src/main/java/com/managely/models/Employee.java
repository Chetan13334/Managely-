package com.managely.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
		@Id 
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
		@Column(name ="name")
	    private String name;
		@Column(name ="salary")
	    private long salary;
		@Column(name ="age")
	    private int age;

	    public Employee(){

	    }
	    public Employee( String name, long salary, int age) {
	        this.name = name;
	        this.salary = salary;
	        this.age = age;
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public long getSalary() {
	        return salary;
	    }

	    public void setSalary(long salary) {
	        this.salary = salary;
	    }

	    public int getAge() {
	        return age;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	   
	    
	}



