package com.example.Day6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Day6.model.CollegeModel;
import com.example.Day6.service.Collegeservice;

@RestController
public class Collegecontroller {
	@Autowired
	Collegeservice cser;
    //postMapping
	@PostMapping("/save")
		public CollegeModel saveDetails(@RequestBody CollegeModel cm) {
			return cser.saveDetails(cm);
		}
	
	//sorting Asc
	@GetMapping("/sortAsc/{name}")
	public List<CollegeModel> sortasc(@PathVariable("name") String name){
		return cser.sortByAsc(name);
	}
	//sorting Desc
		@GetMapping("/sortDesc/{name}")
		public List<CollegeModel> sortdesc(@PathVariable("name") String name){
			return cser.sortByDesc(name);
		}
	//pagination
	@GetMapping("/pagination/{num}/{size}")
	public List<CollegeModel> paginationEx(@PathVariable("num") int num,@PathVariable("size") int size){
		return cser.pagination(num, size);
	}
	//pagination and sorting
	@GetMapping("/paginationAndSort/{num}/{size}/{name}")
	public List<CollegeModel> paginationAndSort(@PathVariable("num") int num,@PathVariable("size") int size,@PathVariable("name") String name){
		return cser.paginationAndSort(num, size,name);
	}
}
