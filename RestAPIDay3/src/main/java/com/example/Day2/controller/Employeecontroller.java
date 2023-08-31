package com.example.Day2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Day2.model.Employee;
import com.example.Day2.repository.Employeerepo;
import com.example.Day2.service.Employeeservice;


@RestController
@RequestMapping("/")
public class Employeecontroller {
	@Autowired
      public Employeeservice esev;
	  public Employeerepo erep;
      
      @PostMapping("/save")
      public Employee saveDetails(@RequestBody Employee e) {
      	return esev.saveDetails(e);
      }
      
      @GetMapping("/get")
      public List<Employee> getDetails(){
      	return esev.getDetails();
      }
      
      @GetMapping("/get/{eid}")
      public ResponseEntity<String>updateBooking(@PathVariable int eid){
          boolean updated=esev.getbyId(eid);
          if(updated) {
                   return ResponseEntity.ok(eid+" GOT SUCCESSFULLY");
           }
          else {
                   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(eid+"  NOT FOUND");
           }
      }
}
