package com.example.Rev2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Rev2.model.Room;

public interface Roomrepo extends JpaRepository<Room, Integer>{
	
	        //nativeQuery
			@Query(value="select * from Room", nativeQuery=true)
			public List<Room> getAllRows();  
			
			
			@Query(value="select * from Room where roomtype=:rtype and price=:price", nativeQuery=true)
			public List<Room> getSpecRows(@Param("rtype") String rtype,@Param("price") Double price);

}
