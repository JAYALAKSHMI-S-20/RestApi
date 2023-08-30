package com.example.Rev2.controller;

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

import com.example.Rev2.model.Booking;
import com.example.Rev2.service.Bookingservice;

@RestController
@RequestMapping("/")
public class Bookingcontroller {
	  @Autowired
      public Bookingservice bsev;
      
      @PostMapping("/saveBooking")
     // @Tag(name="POST", description="TO POST THE DETAILS")
      public Booking saveDetails(@RequestBody Booking b) {
      	return bsev.saveDetails(b);
      }
      
      @GetMapping("/getBooking")
      //@Tag(name="GET", description="TO GET THE DETAILS")
      public List<Booking> getDetails(){
      	return bsev.getDetails();
      }
      
      @PutMapping("/updateBooking/{bid}")
      //@Tag(name="UPDATE", description="TO UPDATE THE DETAILS")
      public ResponseEntity<String>updateBooking(@PathVariable int bid){
      boolean updated=bsev.updateBookingif(bid);
      if(updated) {
               return ResponseEntity.ok(bid+" BOOKED SUCCESSFULLY");
       }
      else {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bid+"  ALREADY BOOKED");
       }
      }
    
      @DeleteMapping("/deleteBooking/{bid}")
      public ResponseEntity<String> deleteRoom(@PathVariable int bid){
     	 boolean deleted = bsev.deleteBookingif(bid);
     	 if(deleted) {
     		 return ResponseEntity.ok(bid+" DELETED SUCCESSFULLY");
     	 }
     	 else {
     		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bid+" ALREADY DELETED");
     	 }
      }
      
}