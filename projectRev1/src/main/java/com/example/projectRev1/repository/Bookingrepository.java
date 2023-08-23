package com.example.projectRev1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectRev1.model.Bookingmodel;

public interface Bookingrepository extends JpaRepository<Bookingmodel,Integer>{

}
