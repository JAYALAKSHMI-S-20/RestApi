package com.example.Day6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import com.example.Day6.controller.Page;
import com.example.Day6.model.CollegeModel;
import com.example.Day6.repository.Collegerepository;

@Service
public class Collegeservice {
	@Autowired
	public Collegerepository crep;
	//post the data
	public CollegeModel saveDetails(CollegeModel c) {
		return crep.save(c);
	}
	//sorting Asc
	public List<CollegeModel> sortByAsc(String name){
		return crep.findAll(Sort.by(name).ascending());
	}
	//sorting Desc
		public List<CollegeModel> sortByDesc(String name){
			return crep.findAll(Sort.by(name).descending());
		}
	//pagination
		public List<CollegeModel> pagination(int pageNo,int pageSize){
			Page<CollegeModel> cont= crep.findAll(PageRequest.of(pageNo, pageSize));
			return cont.getContent();
		}
		//pagination and sorting
		public List<CollegeModel> paginationAndSort(int pageNo,int pageSize,String name){
			Page<CollegeModel> cont= crep.findAll(PageRequest.of(pageNo, pageSize,Sort.by(name)));
			return cont.getContent();
		}

}
