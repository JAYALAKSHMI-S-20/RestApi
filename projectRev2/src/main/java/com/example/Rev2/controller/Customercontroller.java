package com.example.Rev2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Rev2.model.Customer;
import com.example.Rev2.service.Customerservice;

@RestController
@RequestMapping("/")
public class Customercontroller {
	@Autowired
    public Customerservice csev;
	
    @PostMapping("/saveCustomer")
    // @Tag(name="POST", description="TO POST THE DETAILS")
     public Customer saveDetails(@RequestBody Customer c) {
     	return csev.saveDetails(c);
     }
     
     @GetMapping("/getCustomer")
     //@Tag(name="GET", description="TO GET THE DETAILS")
     public List<Customer> getDetails(){
     	return csev.getDetails();
     }
     
     //sort by ascending
     @GetMapping("/sortAsc/{cid}")
     public List<Customer> sortasc(@PathVariable("cid") String cid){
   	      return csev.sortByAsc(cid);
     }
     
     //sort by descending
     @GetMapping("/sortDesc/{cid}")
     public List<Customer> sortdesc(@PathVariable("cid") String cid){
   	      return csev.sortByDesc(cid);
     }
     
     //pagination
     @GetMapping("/pagination/{num}/{size}")
     public List<Customer>paginationEx(@PathVariable("num") int num,@PathVariable("size")int size){
   	      return csev.pagination(num, size);
     }
     
     //pagination and sorting
     @GetMapping("paginationAndSort/{num}/{size}/{cid}")
     public List<Customer> paginationAndSort(@PathVariable("num") int num,@PathVariable("size") int size,@PathVariable("cid") String cid){ 
   	      return csev.paginationAndSort(num,size,cid);
     }

}
