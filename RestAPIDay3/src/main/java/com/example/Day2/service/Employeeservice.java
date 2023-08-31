package com.example.Day2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Day2.model.Employee;
import com.example.Day2.repository.Employeerepo;



@Service
public class Employeeservice {
	@Autowired
	public Employeerepo erep;
	
	 //post the data
    public Employee saveDetails(Employee e) {
   	 return erep.save(e);
    }
    
    //get the data
    public List<Employee> getDetails(){
   	 return erep.findAll();
    }

    public boolean getbyId(int eid) {
   	 if(erep.existsById(eid)) {
   		 return true;
   	 }
   	 return false;
    }
    
   
}
