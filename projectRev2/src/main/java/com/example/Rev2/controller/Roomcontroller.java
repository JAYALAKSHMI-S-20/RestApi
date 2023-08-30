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

import com.example.Rev2.model.Room;
import com.example.Rev2.service.Roomservice;

@RestController
@RequestMapping("/")
public class Roomcontroller {
           @Autowired
           public Roomservice rsev;
           
           @PostMapping("/saveRoom")
          // @Tag(name="POST", description="TO POST THE DETAILS")
           public Room saveDetails(@RequestBody Room r) {
           	    return rsev.saveDetails(r);
           }
           
           @GetMapping("/getRoom")
           //@Tag(name="GET", description="TO GET THE DETAILS")
           public List<Room> getDetails(){
           	    return rsev.getDetails();
           }
           
           @PutMapping("/updateRoom/{guestid}")
           //@Tag(name="UPDATE", description="TO UPDATE THE DETAILS")
           public ResponseEntity<String>updateRoom(@PathVariable int guestid){
           boolean updated=rsev.updateRoomif(guestid);
           if(updated) {
	                return ResponseEntity.ok(guestid+" ROOM UPDATED SUCCESSFULLY");
            }
           else {
	                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(guestid+"  NOT FOUND");
	        }
           
           }
         
           @DeleteMapping("/deleteRoomif/{guestid}")
           public ResponseEntity<String> deleteRoom(@PathVariable int guestid){
          	    boolean deleted = rsev.deleteRoomif(guestid);
          	    if(deleted) {
          		      return ResponseEntity.ok("USERID "+guestid+" DELETED");
          	     }
          	    else {
          		      return ResponseEntity.status(HttpStatus.NOT_FOUND).body( guestid+" NOT FOUND");
          	     }
           }
           
           //get all the data
           @GetMapping("/getAllrows")
           public List<Room> getAllRows(){
        	    return rsev.getAllRows();
           }
           
           //get specific data
           @GetMapping("/getSpecific/{type}/{price}")
           public List<Room> getSpec(@PathVariable("type") String rtype,@PathVariable("price") Double price){
        	    return rsev.getSpecRows(rtype, price);
           }
           
}

