package com.example.projectRev1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projectRev1.model.Bookingmodel;
import com.example.projectRev1.repository.Bookingrepository;

@Service
public class Bookingservice {
      @Autowired
      public Bookingrepository brep;
      
      //post the data
      public String saveBooking(Bookingmodel b) {
  	    brep.save(b);
  	    return "data is saved successfully";
     }
      //get the data
     public List<Bookingmodel>getBooking(){
  	   return brep.findAll();
     }
     //put the data
     public Bookingmodel updateBooking(Bookingmodel b) {
  	   return brep.saveAndFlush(b);
     }
     //delete if id is present
     public boolean deleteBookingif(int roomid) {
  	   if(brep.existsById(roomid)) {
  		   brep.deleteById(roomid);
  		   return true;
  	   }
  	   return false;
     }
     public boolean updateBookingif(int roomid) {
  	   if(brep.existsById(roomid)) {
  		  
  		   return true;
  	   }
  	   return false;
     }
     //delete the data
     public void deleteBooking(int room_id) {
  	   System.out.println("Deleted");
  	   brep.deleteById(room_id);
     }
     public Optional<Bookingmodel> getUserId(int userId){
  	   Optional<Bookingmodel> room = brep.findById(userId);
  	   if(room.isPresent()) {
  		   return room;
  	   }
  	   return null;
     }
}
