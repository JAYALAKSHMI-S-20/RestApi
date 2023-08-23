package com.example.projectRev1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.projectRev1.model.Bookingmodel;
import com.example.projectRev1.service.Bookingservice;

@RestController
	public class Bookingcontroller {
		 @Autowired
	     public Bookingservice bsep;
	      @PostMapping("/saveBooking")
	      public  String postBookingInfo(@RequestBody Bookingmodel b) {
	     	  bsep.saveBooking(b);
	     	  return "data saved successfully";
	      }
	      @GetMapping("/getBooking")
	      public List<Bookingmodel>getBookingInfo(){
	     	 return bsep.getBooking();
	      }
	      @PutMapping("/updateBooking")
	      public Bookingmodel updateBookingInfo(@RequestBody Bookingmodel b) {
	     	 return bsep.updateBooking(b);
	      }
	      @PutMapping("/updateBooking/{roomid}")
	      public ResponseEntity<String>updateBookingInfo(@PathVariable int roomid){
	     	 boolean updated=bsep.updateBookingif(roomid);
	     	 if(updated) {
	     		 return ResponseEntity.ok(roomid+" id updated successfully");
	     	 }
	     	 else {
	     		 
	     		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(roomid+" id not found");
	     	 }
	      }
	      @DeleteMapping("/deleteBooking/{id}")
	      public ResponseEntity<String> deleteBooking(@PathVariable int id){
	     	 boolean deleted =bsep.deleteBookingif(id);
	     	 if(deleted) {
	     		 return ResponseEntity.ok(+id+" id deleted successfully");
	     	 }
	     	 else {
	     		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(id+" id not found");
	     	 }
	      }
	      @DeleteMapping("/byRegparam")
	      public String removeByRequestPam(@RequestParam("id") int id) {
	    	  bsep.deleteBooking(id);
	    	  return "Booking with id "+id+" deleted successfully";
	     }
	      @DeleteMapping("user/{userId}")  
	      public ResponseEntity<?>getUserId(@PathVariable int userId){
	     	 Optional<Bookingmodel> room =bsep.getUserId(userId);
	     	 if(room !=null) {
	     		 return ResponseEntity.ok(room);
	     	 }
	     	 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not available with ID");
	      }
}
