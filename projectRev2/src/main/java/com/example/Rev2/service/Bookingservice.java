package com.example.Rev2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Rev2.model.Booking;
import com.example.Rev2.repository.Bookingrepo;

@Service
public class Bookingservice {
     @Autowired
     public Bookingrepo brep;
     
     //post the data
     public Booking saveDetails(Booking b) {
    	 return brep.save(b);
     }
     
     //get the data
     public List<Booking> getDetails(){
    	 return brep.findAll();
     }
     
     //update the data
     public boolean updateBookingif(int guestid) {
    	 if(brep.existsById(guestid)) {
    		 return true;
    	 }
    	 return false;
     }
     
     //delete the data
     public boolean deleteBookingif(int guestid) {
    	 if(brep.existsById(guestid)) {
    		 brep.deleteById(guestid);
    		 return true;
    	 }
    	 return false;
     }
}
