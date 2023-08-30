package com.example.Rev2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.Rev2.model.Customer;
import com.example.Rev2.repository.Customerrepo;

@Service
public class Customerservice {
	@Autowired
	public Customerrepo crep;
	
	//post the data
	public Customer saveDetails(Customer c) {
		return crep.save(c);
	}
	
	//get the data
	public List<Customer> getDetails(){
		return crep.findAll();
	}
	
	//sort Asc
    public List<Customer> sortByAsc(String cid){
   	     return crep.findAll(Sort.by(cid).ascending());
    }
    
    //sort Desc
    public List<Customer> sortByDesc(String cid){
   	     return crep.findAll(Sort.by(cid).descending());
    }
    
    //pagination
    public List<Customer> pagination(int num,int size){
   	     Page<Customer>cont=crep.findAll(PageRequest.of(num, size));
   	     return cont.getContent();
    }
    
    //pagination and sorting
    public List<Customer> paginationAndSort(int num,int size,String cid){
         Page<Customer> cont1=crep.findAll(PageRequest.of(num,size,Sort.by(cid)));
         return cont1.getContent();
    }

}
