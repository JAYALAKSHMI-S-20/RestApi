package com.example.swagger.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swagger.model.Usermodel;
import com.example.swagger.repository.Userrepo;

@Service
public class Userservice {
	@Autowired
	public Userrepo urep;
	//post the data
	public Usermodel saveDetails(Usermodel u) {
		return urep.save(u);
	}
	//get the data
	public List<Usermodel> getDetails(){
		return urep.findAll();
	}
    //delete the data
	public void deleteDetails(Long uid) {
		System.out.print("Id is deleted");
		urep.deleteById(uid);
	}
	//update the data
    public boolean updateBookingif(Long uid) {
   	 if(urep.existsById(uid)) {
   		 return true;
   	 }
   	 return false;
    }
    //delete the data
    public boolean deleteBookingif(Long uid) {
   	 if(urep.existsById(uid)) {
   		 urep.deleteById(uid);
   		 return true;
   	 }
   	 return false;
    }
}
