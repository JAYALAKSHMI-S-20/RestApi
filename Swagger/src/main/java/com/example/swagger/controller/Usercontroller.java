package com.example.swagger.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.swagger.model.Usermodel;
import com.example.swagger.service.Userservice;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/")
public class Usercontroller {
	@Autowired
	public Userservice userv;
	@PostMapping("/save")
	@Tag(name="post", description="put data")
	public Usermodel saveDetails(@RequestBody Usermodel u) {
		return userv.saveDetails(u);
	}
	
    @GetMapping("/get")
    @Tag(name="Get", description="Get data")
    public List <Usermodel> getDetails(){
    	return userv.getDetails();
    }
    
    @PutMapping("/updateBooking/{uid}")
    @Tag(name="Update", description="Delete the details")
    public ResponseEntity<String>updateBooking(@PathVariable Long uid){
    boolean updated=userv.updateBookingif(uid);
    if(updated) {
             return ResponseEntity.ok(uid+" ID UPDATED SUCCESSFULLY");
     }
    else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(uid+" ID NOT FOUND");
     }
    }
  
    @DeleteMapping("/deleteBooking/{uid}")
    @Tag(name="Delete", description="Update the details")
    public ResponseEntity<String> deleteRoom(@PathVariable Long uid){
   	 boolean deleted = userv.deleteBookingif(uid);
   	 if(deleted) {
   		 return ResponseEntity.ok(uid+" ID DELETED SUCCESSFULLY");
   	 }
   	 else {
   		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(uid+" ID NOT FOUND");
   	 }
    }
  
}
